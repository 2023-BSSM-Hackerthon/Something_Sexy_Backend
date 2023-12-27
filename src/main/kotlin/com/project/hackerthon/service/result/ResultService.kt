package com.project.hackerthon.service.result

import com.project.hackerthon.controller.result.dto.ResultDto
import com.project.hackerthon.controller.result.dto.toEntity
import com.project.hackerthon.domain.result.Result
import com.project.hackerthon.repository.ResultRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ResultService (
    private val resultRepo: ResultRepo
)
{
    fun createResult(dto: ResultDto): Result {
        var result = resultRepo.save(dto.toEntity())
        return result
    }

    fun readResult(id: Long): Result{
        var result = resultRepo.findById(id).get()
        return result
    }
}