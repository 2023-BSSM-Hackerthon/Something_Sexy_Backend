package com.project.hackerthon.global.error

import com.project.hackerthon.global.error.exception.CustomException
import com.project.hackerthon.global.error.exception.ErrorCode
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.JwtException
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException

@Component
class ExceptionFilter: OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (e: CustomException) {
            writeErrorCode(response, e.getErrorCode())
        } catch (e: ExpiredJwtException) {
            writeErrorCode(response, ErrorCode.EXPIRED_TOKEN)
        } catch (e: JwtException) {
            writeErrorCode(response, ErrorCode.INVALID_TOKEN)
        } catch (e: Exception) {
            logger.error(e)
            writeErrorCode(response, ErrorCode.INTERNAL_SERVER_ERROR)
        }
    }

    @Throws(IOException::class)
    private fun writeErrorCode(response: HttpServletResponse, errorCode: ErrorCode) {
        val errorResponse = ErrorResponse(
            errorCode.status,
            errorCode.code,
            errorCode.message
        )
        response.status = errorResponse.status
        response.characterEncoding = "UTF-8"
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(errorResponse.toString())
    }
}