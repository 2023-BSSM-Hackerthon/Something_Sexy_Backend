package com.project.hackerthon.controller.form.dto

import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.domain.form.ThemeType
import com.project.hackerthon.domain.user.User
import java.util.*

data class ApplyFormDto(
    val title: String,
    val content: String,
    val theme: ThemeType,
    val author: User,
    val possibleTime: Date,
    val state: Boolean
)

fun ApplyFormDto.toEntity() = Form(
    title = title,
    content = content,
    theme = theme,
    author = author,
    possibleTime = possibleTime,
    state = state
)