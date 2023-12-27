package com.project.hackerthon.service.auth.clients.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "oauth.bsm")
data class BsmOAuthProperties(
    val clientId: String,
    val clientSecret: String,
)
