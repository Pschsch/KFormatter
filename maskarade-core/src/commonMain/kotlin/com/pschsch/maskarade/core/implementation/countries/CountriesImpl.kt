package com.pschsch.maskarade.core.implementation.countries

import com.pschsch.maskarade.core.api.countries.Countries
import com.pschsch.maskarade.core.api.countries.Country
import com.pschsch.maskarade.core.api.mask.Mask
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI


@OptIn(IncubatingMaskaradeAPI::class)
internal object CountriesImpl : Countries, Collection<Country> by createCountriesList() {
    override val allMasks: List<Mask> by lazy {
        flatMap {
            listOf(it.phoneMask(false), it.phoneMask(true))
        }
    }
}