package com.project.hackerthon.repository

import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.domain.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface FormRepo : JpaRepository<Form,Long> {

    fun findByAuthor(user: User): List<Form>
}