package com.project.hackerthon.controller.form

import com.project.hackerthon.controller.form.dto.ApplyFormDto
import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.service.form.FormReadService
import com.project.hackerthon.service.form.FormService
import org.springframework.http.ResponseEntity
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
    private val formService: FormService,
    private val formReadService: FormReadService
) {
    @GetMapping
    fun readAllApply(): ResponseEntity<List<Form>> {
        return ResponseEntity.ok(formReadService.readAllForm())
    }

    @GetMapping("/{id}")
    fun readApply(@PathVariable id: Long): ResponseEntity<Form> {
        return ResponseEntity.ok(formReadService.readForm(id))
    }

    @PostMapping
    fun createApply(@RequestBody dto: ApplyFormDto): Long {
        return formService.createForm(dto)
    }

    @PatchMapping("/{id}")
    fun allowApply(@PathVariable id: Long): Long {
        return formService.allow(id)
    }

    @PutMapping("/{id}")
    fun updateApply(@PathVariable id: Long,
                    @RequestBody dto: ApplyFormDto): Long {
        return formService.updateForm(id,dto)
    }

    @DeleteMapping("/{id}")
    fun deleteApply(@PathVariable id: Long): Long {
        return formService.deleteForm(id)
    }
}