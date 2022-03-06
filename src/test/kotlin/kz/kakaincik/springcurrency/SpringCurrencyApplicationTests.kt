package kz.kakaincik.springcurrency

import kz.kakaincik.springcurrency.repository.RateRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class SpringCurrencyApplicationTests(
    @Autowired private val repository: RateRepository
    ) {
    @Test
	fun `should provide five business days`() {
        val USD = "USD"
        val rates = repository.askWeekRate(USD)

        assert(rates.rates.size == 5)
    }
}