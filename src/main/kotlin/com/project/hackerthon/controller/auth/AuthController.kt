package com.project.hackerthon.controller.auth

import com.project.hackerthon.controller.auth.dto.response.LoginResponseDto
import com.project.hackerthon.service.auth.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authService: AuthService,
) {

    @PostMapping("/student")
    fun loginStudent(@RequestParam(name = "code") code: String): LoginResponseDto = authService.student(code)

    @PostMapping("/teacher")
    fun loginTeacher(@RequestParam(name = "code") code: String): LoginResponseDto = authService.teacher(code)
}