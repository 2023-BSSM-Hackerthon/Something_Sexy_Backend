package com.project.hackerthon.global.security.auth

import com.project.hackerthon.domain.user.User
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: User
): UserDetails {

    override fun getAuthorities(): List<SimpleGrantedAuthority> {
        return listOf(
            SimpleGrantedAuthority(user.authority.name)
        )
    }

    override fun getPassword(): String? {
        return null
    }

    override fun getUsername(): String {
        return user.id.toString()
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }
}