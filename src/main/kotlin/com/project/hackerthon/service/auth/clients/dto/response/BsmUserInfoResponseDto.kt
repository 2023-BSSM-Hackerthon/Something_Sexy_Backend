package com.project.hackerthon.service.auth.clients.dto.response

data class BsmUserInfoResponseDto(
    val user: User,
)

data class User(
    val name: String,
    val grade: Int?,
    val classNo: Int?,
    val studentNo: Int?,
    val email: String
)
