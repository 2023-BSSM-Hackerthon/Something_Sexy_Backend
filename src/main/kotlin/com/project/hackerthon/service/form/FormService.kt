package com.project.hackerthon.service.form

import com.project.hackerthon.controller.form.dto.ApplyFormDto
import com.project.hackerthon.controller.form.dto.toEntity
import com.project.hackerthon.global.error.exception.CustomException
import com.project.hackerthon.global.error.exception.ErrorCode
import com.project.hackerthon.repository.FormRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FormService (
    private val formRepo: FormRepo,
    private val formReadService: FormReadService
) {
    fun createForm(dto: ApplyFormDto): Long {
        return formRepo.save(dto.toEntity()).id
    }

    fun updateForm(id: Long, dto: ApplyFormDto): Long {
        val form = formReadService.readForm(id)

        if (form.state) {
            throw CustomException(ErrorCode.ALREADY_APPROVED_FORM)
        }

        return formRepo.save(form.update(dto)).id
    }

    fun deleteForm(id: Long) : Long {
        formRepo.deleteById(id)
        return id
    }

    fun allow(id: Long): Long {
        val form = formReadService.readForm(id)
        return formRepo.save(form.allow()).id
    }
}