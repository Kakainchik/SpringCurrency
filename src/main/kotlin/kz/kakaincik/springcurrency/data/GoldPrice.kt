package kz.kakaincik.springcurrency.data

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate

data class DTOAverageGoldPrice(
    val startPeriod: LocalDate,
    val endPeriod: LocalDate,
    val price: Double
)

data class NBPGoldPrice(
    @JsonProperty("data") val date: LocalDate,
    @JsonProperty("cena") val price: Double
)