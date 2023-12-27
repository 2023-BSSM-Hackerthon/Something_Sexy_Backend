package com.project.hackerthon.service.result

import com.project.hackerthon.controller.result.dto.ResultDto
import com.project.hackerthon.controller.result.dto.toEntity
import com.project.hackerthon.domain.user.User
import com.project.hackerthon.repository.ResultRepo
import com.project.hackerthon.repository.UserRepo
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ResultService (
    private val resultRepo: ResultRepo,
    private val userRepo: UserRepo,
) {
    fun createResult(dto: ResultDto): Long {
        val student: User = userRepo.findById(dto.student).get()
        val teacher: User = userRepo.findById(dto.teacher).get()
        return resultRepo.save(dto.toEntity(teacher, student)).id
    }
}