package com.project.hackerthon.global.error.exception

enum class ErrorCode(
    val status: Int,
    val code: String,
    val message: String
) {

    // user
    USER_NOT_FOUND(404, "USER_404_1", "User not found"),
    UNAUTHORIZED(401, "USER_401_1", "Invalid login"),

    // jwt
    INVALID_TOKEN(403, "JWT_403_1", "Invalid JWT"),
    EXPIRED_TOKEN(403, "JWT_403_2", "JWT Expired"),

    // form
    FORM_NOT_FOUND(404, "FORM_404_1", "Form not found"),
    ALREADY_APPROVED_FORM(409, "FORM_409_1", "Already approved form"),

    // server
    INTERNAL_SERVER_ERROR(500, "SERVER_500_1", "Internal server error"),
}
