package kz.kakaincik.springcurrency.service

import kz.kakaincik.springcurrency.data.DTOAverageGoldPrice

interface GoldService {
    fun getAveragePrice(): DTOAverageGoldPrice?
}