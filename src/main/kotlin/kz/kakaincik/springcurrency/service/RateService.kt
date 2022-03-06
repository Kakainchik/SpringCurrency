package kz.kakaincik.springcurrency.service

import kz.kakaincik.springcurrency.data.Rate

interface RateService {
    fun getWeekRate(code: String): Rate
}