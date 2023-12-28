package com.project.hackerthon.service.form

import com.project.hackerthon.controller.form.dto.ApplyFormDto
import com.project.hackerthon.controller.form.dto.ApplyRejectDto
import com.project.hackerthon.controller.form.dto.toEntity
import com.project.hackerthon.domain.user.User
import com.project.hackerthon.global.error.exception.CustomException
import com.project.hackerthon.global.error.exception.ErrorCode
import com.project.hackerthon.repository.FormRepo
import com.project.hackerthon.service.mail.MailService
import com.project.hackerthon.service.user.UserGetService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FormService (
    private val formRepo: FormRepo,
    private val formReadService: FormReadService,
    private val mailService: MailService,
    private val userGetService: UserGetService,
) {
    fun createForm(dto: ApplyFormDto): Long {
        val user: User = userGetService.findById(dto.author)

        userGetService.findAllTeacher()
            .map { element -> mailService.toTeacher(element) }

        return formRepo.save(dto.toEntity(user)).id
    }

    fun rejectForm(id: Long, dto: ApplyRejectDto): Long {
        val form = formReadService.readForm(id)

        if (form.state) {
            throw CustomException(ErrorCode.ALREADY_APPROVED_FORM)
        }

        mailService.toStudentWhenReject(form, dto.content)

        return id
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

        mailService.toStudentWhenApprove(form)

        return formRepo.save(form.allow()).id
    }
}