package com.project.hackerthon.service.form

import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.domain.user.User
import com.project.hackerthon.global.error.exception.CustomException
import com.project.hackerthon.global.error.exception.ErrorCode
import com.project.hackerthon.repository.FormRepo
import com.project.hackerthon.service.user.UserGetService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class FormReadService(
    private val formRepo: FormRepo,
    private val userGetService: UserGetService
) {

    fun readAllForm(): List<Form> {
        return formRepo.findAll()
    }

    fun readForm(id: Long): Form {
        return formRepo.findById(id).orElseThrow{ CustomException(ErrorCode.FORM_NOT_FOUND) }
    }

    fun readFormByUser(): List<Form> {
        val user: User = userGetService.findOne()
        return formRepo.findByAuthor(user)
    }
}