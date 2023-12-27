package com.project.hackerthon.service.result

import com.project.hackerthon.domain.result.Result
import com.project.hackerthon.global.error.exception.CustomException
import com.project.hackerthon.global.error.exception.ErrorCode
import com.project.hackerthon.repository.ResultRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ResultReadService (
    private val resultRepo: ResultRepo
) {
    fun readResult(id: Long): Result {
        return resultRepo.findById(id).orElseThrow { CustomException(ErrorCode.RESULT_NOT_FOUND) }
    }
}