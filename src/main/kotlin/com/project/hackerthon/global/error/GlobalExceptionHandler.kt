package com.project.hackerthon.global.error

import com.project.hackerthon.global.error.exception.CustomException
import com.project.hackerthon.global.error.exception.ErrorCode
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(CustomException::class)
    fun nodamExceptionHandler(e: CustomException): ResponseEntity<ErrorResponse> {
        val errorCode: ErrorCode = e.getErrorCode()

        return ResponseEntity
            .status(HttpStatus.valueOf(errorCode.status))
            .body(
                ErrorResponse(
                    errorCode.status,
                    errorCode.code,
                    errorCode.message
                )
            )
    }
}

