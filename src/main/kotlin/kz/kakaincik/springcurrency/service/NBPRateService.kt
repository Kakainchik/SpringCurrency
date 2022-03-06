package kz.kakaincik.springcurrency.service

import kz.kakaincik.springcurrency.data.Rate
import kz.kakaincik.springcurrency.repository.RateRepository
import org.springframework.stereotype.Service

@Service
class NBPRateService(private val repository: RateRepository) : RateService {
    override fun getWeekRate(code: String): Rate {
        return repository.askWeekRate(code)
    }
}