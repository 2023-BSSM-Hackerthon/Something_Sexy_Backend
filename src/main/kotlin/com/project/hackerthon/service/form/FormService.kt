package com.project.hackerthon.service.form

import com.project.hackerthon.controller.form.dto.ApplyFormDto
import com.project.hackerthon.controller.form.dto.toEntity
import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.repository.FormRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class FormService (
    private val formRepo: FormRepo,
){
    fun createApply(dto: ApplyFormDto): Form {
        return formRepo.save(dto.toEntity())
    }

    fun readAllApply(): List<Form> {
        return formRepo.findAll()
    }
    fun readApply(id: Long): Form {
        var form = formRepo.findById(id)
        if(form.isPresent()) {
            return form.get()
        }
        throw IllegalArgumentException("존재하지 않는 Form 입니다.")
    }

    fun updateApply(id: Long,dto: ApplyFormDto): Form {
        var form = formRepo.findById(id).get()
        if (form.state == true) {
            throw IllegalArgumentException("이미 승인된 form 입니다.")
        }

        return form.update(dto)
    }

    fun deleteApply(id: Long) : Long{
        formRepo.deleteById(id)
        return id
    }

    fun allow(id: Long): Form {
        var form = formRepo.findById(id).get()
        return form.allow()
    }
}