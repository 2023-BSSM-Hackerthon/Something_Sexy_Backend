package com.project.hackerthon.domain.user

import com.project.hackerthon.global.entity.BaseDateTime
import com.project.hackerthon.service.auth.clients.dto.response.BsmUserInfoResponseDto
import jakarta.persistence.*

@Entity
class User private constructor(
    name: String,
    email: String,
    authority: Authority,
    group: Int,
    number: Int,
    grade: Int,
): BaseDateTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Column(nullable = false)
    var name: String = name
        protected set

    @Column(nullable = false)
    var email: String = email
        protected set

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var authority: Authority = authority
        protected set

    @Column(nullable = false)
    var classes: Int = group
        protected set

    @Column(nullable = false)
    var number: Int = number
        protected set

    @Column(nullable = false)
    var grade: Int = grade
        protected set

    companion object {
        fun createStudent(dto: BsmUserInfoResponseDto): User = User(
            name = dto.user.name,
            email = dto.user.email,
            authority = Authority.STUDENT,
            group = dto.user.classNo!!,
            number = dto.user.studentNo!!,
            grade = dto.user.grade!!,
        )

        fun createTeacher(dto: BsmUserInfoResponseDto): User = User(
            name = dto.user.name,
            email = dto.user.email,
            authority = Authority.TEACHER,
            group = 0,
            number = 0,
            grade = 0
        )
    }
}