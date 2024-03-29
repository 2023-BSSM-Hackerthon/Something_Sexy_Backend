package com.project.hackerthon.service.user

import com.project.hackerthon.domain.user.User
import com.project.hackerthon.repository.UserRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class UserSaveService(
    private val userRepo: UserRepo,
) {

    fun execute(user: User): Long {
        return userRepo.save(user).id
    }
}