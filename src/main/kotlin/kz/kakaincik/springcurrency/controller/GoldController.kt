package kz.kakaincik.springcurrency.controller

import kz.kakaincik.springcurrency.data.DTOAverageGoldPrice
import kz.kakaincik.springcurrency.service.GoldService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.HttpClientErrorException

@RestController
@RequestMapping("/api")
class GoldController(private val service: GoldService) {
    @GetMapping("/gold-price/average")
    fun getAverage2WeeksPrice(): ResponseEntity<DTOAverageGoldPrice> {
        return try {
            ResponseEntity.ok(service.getAveragePrice())
        } catch(ex: HttpClientErrorException) {
            ResponseEntity.status(ex.statusCode)
                .build()
        }
    }
}