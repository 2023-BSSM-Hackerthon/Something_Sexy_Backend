package com.project.hackerthon.service.auth.clients.dto.request

data class BsmTokenRequestDto(
    val clientId: String,
    val clientSecret: String,
    val authCode: String,
)
