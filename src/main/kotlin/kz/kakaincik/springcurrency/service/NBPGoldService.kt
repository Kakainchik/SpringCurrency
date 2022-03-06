package kz.kakaincik.springcurrency.service

import kz.kakaincik.springcurrency.data.DTOAverageGoldPrice
import kz.kakaincik.springcurrency.data.NBPGoldPrice
import kz.kakaincik.springcurrency.repository.GoldRepository
import org.springframework.stereotype.Service

@Service
class NBPGoldService(private val repository: GoldRepository) : GoldService {
    override fun getAveragePrice(): DTOAverageGoldPrice? {
        val prices = repository.askLastDays()

        return calculateAverage(prices.toList())
    }

    private fun calculateAverage(prices: List<NBPGoldPrice>): DTOAverageGoldPrice {
        val avg: Double = prices.sumOf { it.price } / prices.size

        return DTOAverageGoldPrice(
            prices.first().date,
            prices.last().date,
            avg
        )
    }
}