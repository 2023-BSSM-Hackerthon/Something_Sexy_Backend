package com.project.hackerthon.controller.form

import com.project.hackerthon.controller.form.dto.ApplyFormDto
import com.project.hackerthon.controller.form.dto.toDto
import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.service.form.FormService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/form")
class FormController (
    private val formService: FormService
) {
    @GetMapping
    fun readAllApply(): List<Form> {
        return formService.readAllForm()
    }

    @GetMapping("/{id}")
    fun readApply(@PathVariable id: Long): Form {
        return formService.readForm(id)
    }

    @PostMapping
    fun createApply(@RequestBody dto: ApplyFormDto): Form {
        return formService.createForm(dto.toDto())
    }

    @PatchMapping("/{id}")
    fun allowApply(@PathVariable id: Long): Form {
        return formService.allow(id)
    }

    @PutMapping("/{id}")
    fun updateApply(@PathVariable id: Long,@RequestBody dto: ApplyFormDto): Form {
        return formService.updateForm(id,dto)
    }

    @DeleteMapping("/{Id}")
    fun deleteApply(@PathVariable id: Long): Long {
        return formService.deleteForm(id)
    }
}