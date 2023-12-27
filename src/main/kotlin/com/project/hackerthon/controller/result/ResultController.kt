package com.project.hackerthon.controller.result

import com.project.hackerthon.controller.result.dto.ResultDto
import com.project.hackerthon.controller.result.dto.toDto
import com.project.hackerthon.domain.result.Result
import com.project.hackerthon.service.result.ResultReadService
import com.project.hackerthon.service.result.ResultService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/result")
class ResultController (
    private val resultService: ResultService,
    private val resultReadService: ResultReadService
) {
    @GetMapping("/{id}")
    fun readApply(@PathVariable id: Long): ResponseEntity<Result> {
        return ResponseEntity.ok(resultReadService.readResult(id))
    }

    @PostMapping
    fun createApply(@RequestBody dto: ResultDto): Long {
        return resultService.createResult(dto.toDto())
    }
}