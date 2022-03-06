package kz.kakaincik.springcurrency.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.time.LocalDate

@JsonIgnoreProperties(ignoreUnknown = true)
data class Rate(val code: String, val rates: List<DayRate>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class DayRate(val effectiveDate: LocalDate, val mid: Double)