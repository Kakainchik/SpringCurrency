package kz.kakaincik.springcurrency.repository

import kz.kakaincik.springcurrency.data.NBPGoldPrice
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate

@Repository
class GoldRepository(private val client: RestTemplate) {
    fun askLastDays(days: Int = DEFAULT_DAYS): Array<NBPGoldPrice> {
        val params = mapOf<String, Any>(
            "days" to days
        )
        val response = client.getForEntity(
            BASE_URL + LAST_DAYS_URL,
            Array<NBPGoldPrice>::class.java,
            params
        )

        return response.body!!
    }

    companion object {
        private const val BASE_URL = "http://api.nbp.pl/api/cenyzlota"
        private const val LAST_DAYS_URL = "/last/{days}"
        private const val DEFAULT_DAYS: Int = 14
    }
}