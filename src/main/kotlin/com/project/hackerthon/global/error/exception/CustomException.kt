package com.project.hackerthon.global.error.exception

class CustomException(
    private val errorCode: ErrorCode
): RuntimeException()
