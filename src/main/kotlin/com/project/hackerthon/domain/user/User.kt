package com.project.hackerthon.domain.user

import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.global.entity.BaseDateTime
import jakarta.persistence.*

@Entity
class User (
    name: String,
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
    var classes: Int = group
        protected set

    @Column(nullable = false)
    var number: Int = number
        protected set

    @Column(nullable = false)
    var grade: Int = grade
        protected set
}