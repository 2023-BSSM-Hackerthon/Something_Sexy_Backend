package com.project.hackerthon.global.error.exception

enum class ErrorCode(
    val status: Int,
    val code: String,
    val message: String
) {

    // user
    USER_NOT_FOUND(404, "USER_404_1", "User not found"),

    // jwt
    INVALID_TOKEN(403, "JWT_403_1", "Invalid JWT"),
    EXPIRED_TOKEN(403, "JWT_403_2", "JWT Expired"),

    // server
    INTERNAL_SERVER_ERROR(500, "SERVER_500_1", "Internal server error"),
}
