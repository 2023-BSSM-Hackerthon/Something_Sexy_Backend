package com.project.hackerthon.repository

import com.project.hackerthon.domain.user.Authority
import com.project.hackerthon.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface UserRepo : JpaRepository<User,Long> {

    fun findByEmail(email: String): Optional<User>

    fun findByAuthority(authority: Authority): List<User>
}