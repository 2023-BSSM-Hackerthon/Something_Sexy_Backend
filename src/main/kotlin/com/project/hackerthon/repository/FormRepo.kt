package com.project.hackerthon.repository

import com.project.hackerthon.domain.form.Form
import org.springframework.data.jpa.repository.JpaRepository

interface FormRepo : JpaRepository<Form,Long> {
}