package com.project.hackerthon.controller.result.dto

import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.domain.result.Result
import com.project.hackerthon.domain.user.User

data class ResultDto (
    val teacher: Long,
    val student: Long,
    val title: String,
    val content: String,
    val form: Form
)

fun ResultDto.toEntity(teacher: User,student: User) = Result(
    teacher = teacher,
    student = student,
    title = title,
    content = content,
    form = form,
)
