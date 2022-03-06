package kz.kakaincik.springcurrency.repository

import kz.kakaincik.springcurrency.data.Rate
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class RateRepository(private val client: RestTemplate) {
    fun askWeekRate(code: String): Rate {
        val params = mapOf<String, Any>(
            "code" to code,
            "days" to BUSINESS_DAYS_COUNT
        )
        val response = client.getForEntity(
            BASE_URL + CODE_URL + LAST_DAYS_URL,
            Rate::class.java,
            params
        )

        return response.body!!
    }

    companion object {
        private const val BASE_URL = "http://api.nbp.pl/api/exchangerates/rates/A"
        private const val CODE_URL = "/{code}"
        private const val LAST_DAYS_URL = "/last/{days}"
        private const val BUSINESS_DAYS_COUNT: Int = 5
    }
}