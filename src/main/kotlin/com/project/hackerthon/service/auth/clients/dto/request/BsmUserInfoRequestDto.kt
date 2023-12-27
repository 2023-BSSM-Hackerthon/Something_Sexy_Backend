package com.project.hackerthon.service.auth.clients.dto.request

data class BsmUserInfoRequestDto(
    val clientId: String,
    val clientSecret: String,
    val token: String,
)
