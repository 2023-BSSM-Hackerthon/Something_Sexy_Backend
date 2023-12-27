package com.project.hackerthon.global.error.exception

enum class ErrorCode(
    val status: Int,
    val code: String,
    val message: String
) {

    // user
    USER_NOT_FOUND(404, "USER_404_1", "User not found"),
}
