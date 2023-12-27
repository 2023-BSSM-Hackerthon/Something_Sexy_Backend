package com.project.hackerthon.controller.auth

import com.project.hackerthon.controller.auth.dto.response.LoginResponseDto
import com.project.hackerthon.service.auth.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/api/auth/student")
    fun loginStudent(@RequestParam(name = "code") code: String): LoginResponseDto = authService.student(code)

    @PostMapping("/api/auth/teacher")
    fun loginTeacher(@RequestParam(name = "code") code: String): LoginResponseDto = authService.teacher(code)
}