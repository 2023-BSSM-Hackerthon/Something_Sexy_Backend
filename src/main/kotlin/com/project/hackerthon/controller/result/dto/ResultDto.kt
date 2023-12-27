package com.project.hackerthon.controller.result.dto

import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.domain.result.Result
import com.project.hackerthon.domain.user.User

data class ResultDto (
    val teacher: User,
    val student: User,
    val title: String,
    val content: String,
    val form: Form
)

fun ResultDto.toDto() =  ResultDto(
    teacher = teacher,
    student = student,
    title = title,
    content = content,
    form = form,
)

fun ResultDto.toEntity() = Result(
    teacher = teacher,
    student = student,
    title = title,
    content = content,
    form = form,
)
