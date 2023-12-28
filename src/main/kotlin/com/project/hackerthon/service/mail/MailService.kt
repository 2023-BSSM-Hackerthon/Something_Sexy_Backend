package com.project.hackerthon.service.mail

import com.project.hackerthon.domain.form.Form
import com.project.hackerthon.domain.user.User
import jakarta.mail.internet.MimeMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Service

@Service
class MailService(
    private val javaMailSender: JavaMailSender,
) {

    // 학생이 상담 신청을 했을 때
    fun toTeacher(user: User) {
        sender(
            user.email,
            title = "${user.grade}학년 ${user.classes}번 ${user.number}번 ${user.name}님이 상담을 신청했습니다.",
            contents = "http://localhost:3000/applist\n\n" +
                    "위 링크에서 상세 내용을 확인하세요!"
        )
    }

    // 선생님이 거절 했을 때
    fun toStudentWhenReject(form: Form, content: String) {
        sender(
            form.author.email,
            title = "신청이 거절되었습니다.",
            contents = "- 상담 내용\n${form.title}\n\n- 거절 사유\n${content}"
        )
    }

    // 선생님이 수락 했을 때
    fun toStudentWhenApprove(form: Form) {
        sender(
            form.author.email,
            title = "상담 신청이 승인 되었습니다.",
            contents = "- 승인된 상담 내용\n${form.title}\n\n" +
                    "신청한 날짜인 ${form.possibleTime.toString().slice(IntRange(0, 15))} 까지 위클래스에 방문해주세요!"
        )
    }

    private fun sender(email: String, title: String, contents: String): Unit {
        val mimeMessage: MimeMessage = javaMailSender.createMimeMessage()
        val mimeMailHelper = MimeMessageHelper(mimeMessage, false, "utf-8")
        mimeMailHelper.setTo(email)
        mimeMailHelper.setFrom("weet.team14@gmail.com")
        mimeMailHelper.setSubject(title)
        mimeMailHelper.setText(contents)
        javaMailSender.send(mimeMessage)
    }
}