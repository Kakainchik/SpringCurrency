package kz.kakaincik.springcurrency.controller

import kz.kakaincik.springcurrency.data.Rate
import kz.kakaincik.springcurrency.service.RateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/api")
class ExchangeRateController(private val service: RateService) {
    @GetMapping("/exchange-rates/{cur}")
    fun getWeekRates(@PathVariable cur: String): ResponseEntity<Rate> {
        return try {
            ResponseEntity.ok(service.getWeekRate(cur))
        } catch(ex: HttpClientErrorException) {
            ResponseEntity.status(ex.statusCode)
                .build()
        }
    }
}