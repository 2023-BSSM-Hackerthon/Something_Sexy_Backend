package com.project.hackerthon.domain.form

import com.project.hackerthon.domain.user.User
import com.project.hackerthon.global.entity.BaseDateTime
import jakarta.persistence.*
import java.util.Date

@Entity
class Form (
    title: String,
    content: String,
    theme: ThemeType,
    author: User,
    possibleTime: Date
): BaseDateTime() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @Column(nullable = false)
    var title: String = title
        protected set

    @Column(columnDefinition = "TEXT")
    var content: String = content
        protected set

    @Column(nullable = false)
    var possibleTime: Date = possibleTime

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    var theme: ThemeType = theme
        protected set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        nullable = false,
        foreignKey = ForeignKey(name = "FK_FORM_USER_ID")
    )
    var author: User = author
        protected set
}