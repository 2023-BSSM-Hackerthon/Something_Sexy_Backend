package com.project.hackerthon.global.jwt.util

import com.project.hackerthon.global.jwt.config.JwtProperties
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.io.Decoders
import io.jsonwebtoken.security.Keys
import org.springframework.stereotype.Component
import java.util.Date
import javax.crypto.SecretKey

@Component
class JwtProvider(
    private val jwtProperties: JwtProperties,
) {
    fun execute(userId: Long): String {
        return createToken(userId)
    }

    private fun createToken(userId: Long): String {
        val now = Date()
        val claims = Jwts.claims()
        val secretKey: SecretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtProperties.secret))

        claims["userId"] = userId

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(now)
            .setExpiration(Date(now.time + jwtProperties.accessTokenExp))
            .signWith(secretKey, SignatureAlgorithm.HS256)
            .compact()
    }
}