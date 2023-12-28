package com.project.hackerthon.service.user

import com.project.hackerthon.domain.user.Authority
import com.project.hackerthon.domain.user.User
import com.project.hackerthon.global.error.exception.CustomException
import com.project.hackerthon.global.error.exception.ErrorCode
import com.project.hackerthon.repository.UserRepo
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UserGetService(
    private val userRepo: UserRepo,
) {

    fun findByEmail(email: String): User? {
        return userRepo.findByEmail(email).orElse(null)
    }

    fun findById(id: Long): User {
        return userRepo.findById(id).orElseThrow { CustomException(ErrorCode.USER_NOT_FOUND) }
    }

    fun findAllTeacher(): List<User> {
        return userRepo.findByAuthority(Authority.TEACHER)
    }

    fun findOne(): User {
        val userId: Long = SecurityContextHolder.getContext().authentication.name.toLong()
        return findById(userId)
    }
}