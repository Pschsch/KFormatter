package com.pschsch.maskarade.core.countries

import com.pschsch.maskarade.core.countries.internal.CountriesImpl
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI

@IncubatingMaskaradeAPI
interface Countries : Iterable<Country> {
    companion object : Countries by CountriesImpl
}