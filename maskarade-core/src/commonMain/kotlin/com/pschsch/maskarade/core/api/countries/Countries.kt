package com.pschsch.maskarade.core.api.countries

import com.pschsch.maskarade.core.api.mask.Mask
import com.pschsch.maskarade.core.implementation.countries.CountriesImpl
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI

@IncubatingMaskaradeAPI
interface Countries : Iterable<Country> {

    val allMasks : List<Mask>
    companion object : Countries by CountriesImpl
}