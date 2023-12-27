package com.project.hackerthon.repository

import com.project.hackerthon.domain.result.Result
import org.springframework.data.jpa.repository.JpaRepository

interface ResultRepo : JpaRepository<Result,Long> {
}