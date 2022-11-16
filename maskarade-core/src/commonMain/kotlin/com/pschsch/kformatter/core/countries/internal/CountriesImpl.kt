package com.pschsch.kformatter.core.countries.internal

import com.pschsch.kformatter.core.countries.Countries
import com.pschsch.kformatter.core.countries.Country
import com.pschsch.kformatter.core.optin.IncubatingMaskaradeAPI


@OptIn(IncubatingMaskaradeAPI::class)
internal object CountriesImpl : Countries, Collection<Country> by createCountriesList()