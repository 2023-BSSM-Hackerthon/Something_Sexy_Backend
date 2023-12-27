package com.project.hackerthon.repository

import com.project.hackerthon.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepo : JpaRepository<User,Long> {
}