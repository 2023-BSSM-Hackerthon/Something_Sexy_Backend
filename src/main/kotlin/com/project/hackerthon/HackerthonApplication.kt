package com.project.hackerthon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
@ConfigurationPropertiesScan
@EnableFeignClients
class HackerthonApplication

fun main(args: Array<String>) {
	runApplication<HackerthonApplication>(*args)
}
