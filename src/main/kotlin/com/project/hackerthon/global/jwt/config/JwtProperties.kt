package com.project.hackerthon.global.jwt.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    var secret: String,
    var prefix: String,
    var accessTokenExp: Long
)