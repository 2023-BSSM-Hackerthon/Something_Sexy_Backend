package com.project.hackerthon.global.security.auth

import com.project.hackerthon.global.error.exception.CustomException
import com.project.hackerthon.global.error.exception.ErrorCode
import com.project.hackerthon.repository.UserRepo
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepo
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        return userRepository.findById(username.toLong())
            .map { user -> AuthDetails(user) }
            .orElseThrow { CustomException(ErrorCode.USER_NOT_FOUND) }
    }
}