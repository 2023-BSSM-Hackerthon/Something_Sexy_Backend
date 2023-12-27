package com.project.hackerthon.service.auth.clients

import com.project.hackerthon.service.auth.clients.dto.request.BsmTokenRequestDto
import com.project.hackerthon.service.auth.clients.dto.request.BsmUserInfoRequestDto
import com.project.hackerthon.service.auth.clients.dto.response.BsmTokenResponseDto
import com.project.hackerthon.service.auth.clients.dto.response.BsmUserInfoResponseDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping

@FeignClient(
    value = "BsmGetTokenClient",
    url = "https://auth.bssm.kro.kr/api/oauth"
)
interface BsmOAuthClient {

    @PostMapping("/token")
    fun getToken(dto: BsmTokenRequestDto): BsmTokenResponseDto

    @PostMapping("/resource")
    fun getUserInfo(dto: BsmUserInfoRequestDto): BsmUserInfoResponseDto
}