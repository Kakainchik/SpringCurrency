package kz.kakaincik.springcurrency

import kz.kakaincik.springcurrency.util.RestTemplateResponseErrorHandler
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class SpringCurrencyApplication {
	@Bean
	fun restTemplate(builder: RestTemplateBuilder): RestTemplate =
		builder
			.defaultHeader("Accept", "application/json")
			.errorHandler(RestTemplateResponseErrorHandler())
			.build()
}

fun main(args: Array<String>) {
	runApplication<SpringCurrencyApplication>(*args)
}