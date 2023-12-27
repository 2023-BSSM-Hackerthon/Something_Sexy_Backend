package com.project.hackerthon.service.auth

import com.project.hackerthon.controller.auth.dto.response.LoginResponseDto
import com.project.hackerthon.domain.user.User
import com.project.hackerthon.global.jwt.util.JwtProvider
import com.project.hackerthon.service.auth.clients.BsmOAuthClient
import com.project.hackerthon.service.auth.clients.config.BsmOAuthProperties
import com.project.hackerthon.service.auth.clients.dto.request.BsmTokenRequestDto
import com.project.hackerthon.service.auth.clients.dto.request.BsmUserInfoRequestDto
import com.project.hackerthon.service.auth.clients.dto.response.BsmUserInfoResponseDto
import com.project.hackerthon.service.user.UserGetService
import com.project.hackerthon.service.user.UserSaveService
import org.springframework.stereotype.Service

@Service
class AuthService(
    private val userGetService: UserGetService,
    private val userSaveService: UserSaveService,
    private val bsmOAuthClient: BsmOAuthClient,
    private val bsmOAuthProperties: BsmOAuthProperties,
    private val jwtProvider: JwtProvider,
) {

    fun student(code: String): LoginResponseDto {
        val info: BsmUserInfoResponseDto = execute(code)

        val user: User? = userGetService.findByEmail(info.user.email)

        if (user == null) {
            val userId: Long = userSaveService.execute(User.createStudent(info))
            return LoginResponseDto(jwtProvider.execute(userId))
        }

        return LoginResponseDto(jwtProvider.execute(user.id))
    }

    fun teacher(code: String): LoginResponseDto {
        val info: BsmUserInfoResponseDto = execute(code)

        val user: User? = userGetService.findByEmail(info.user.email)

        if (user == null) {
            val userId: Long = userSaveService.execute(User.createTeacher(info))
            return LoginResponseDto(jwtProvider.execute(userId))
        }

        return LoginResponseDto(jwtProvider.execute(user.id))
    }

    private fun execute(code: String): BsmUserInfoResponseDto {
        val token: String = bsmOAuthClient.getToken(
            BsmTokenRequestDto(
                bsmOAuthProperties.clientId,
                bsmOAuthProperties.clientSecret,
                code
            )
        ).token

        return bsmOAuthClient.getUserInfo(
            BsmUserInfoRequestDto(
                bsmOAuthProperties.clientId,
                bsmOAuthProperties.clientSecret,
                token
            )
        )
    }
}