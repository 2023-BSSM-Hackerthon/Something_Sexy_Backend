package com.project.hackerthon.global.error

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper

data class ErrorResponse(
    val status: Int,
    val code: String,
    val message: String
) {
    override fun toString(): String {
        val objectMapper = ObjectMapper()
        return try {
            objectMapper.writeValueAsString(this)
        } catch (e: JsonProcessingException) {
            throw RuntimeException(e)
        }
    }
}
