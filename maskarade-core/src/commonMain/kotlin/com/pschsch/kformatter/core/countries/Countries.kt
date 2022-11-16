package com.pschsch.kformatter.core.countries

import com.pschsch.kformatter.core.countries.internal.CountriesImpl
import com.pschsch.kformatter.core.optin.IncubatingMaskaradeAPI

@IncubatingMaskaradeAPI
interface Countries : Iterable<Country> {
    companion object : Countries by CountriesImpl
}