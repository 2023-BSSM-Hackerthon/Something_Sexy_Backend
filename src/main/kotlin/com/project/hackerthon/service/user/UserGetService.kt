package com.project.hackerthon.service.user

import com.project.hackerthon.domain.user.User
import com.project.hackerthon.repository.UserRepo
import org.springframework.stereotype.Service

@Service
class UserGetService(
    private val userRepo: UserRepo,
) {

    fun findByEmail(email: String): User? {
        return userRepo.findByEmail(email).orElse(null)
    }
}