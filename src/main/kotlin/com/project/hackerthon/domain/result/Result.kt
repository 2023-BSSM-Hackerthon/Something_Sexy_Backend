package com.project.hackerthon.domain.result

import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.domain.user.User
import com.project.hackerthon.global.entity.BaseDateTime
import jakarta.persistence.*

@Entity
class Result(
    teacher: User,
    student: User,
    title : String,
    content: String,
    form: Form
): BaseDateTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "teacher_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_RESULT_TEACHER_ID")
    )
    var teacher: User = teacher
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "student_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_RESULT_STUDENT_ID")
    )
    var student: User = student
        protected set

    @Column(nullable = false)
    var title: String = title
        protected set

    @Column(columnDefinition = "TEXT")
    var content: String = content
        protected set

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_id")
    var form: Form = form
        protected set
}