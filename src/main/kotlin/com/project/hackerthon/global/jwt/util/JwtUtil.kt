package com.project.hackerthon.global.jwt.util

import com.project.hackerthon.global.jwt.config.JwtProperties
import com.project.hackerthon.global.security.auth.AuthDetails
import com.project.hackerthon.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component

@Component
class JwtUtil(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService
) {

    fun getAuthentication(token: String): Authentication {
        val authDetails: AuthDetails = authDetailsService.loadUserByUsername(extractUserId(token)) as AuthDetails

        return UsernamePasswordAuthenticationToken(authDetails, token, authDetails.authorities)
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer: String? = request.getHeader("Authentication")

        if (bearer == null || !bearer.startsWith("Bearer ")) {
            return null
        }

        return bearer.split(" ")[1].trim()
    }

    fun getClaims(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(jwtProperties.secret)
            .build()
            .parseClaimsJws(token)
            .getBody()
    }

    fun extractUserId(token: String): String {
        return getClaims(token)["userId"].toString()
    }
}