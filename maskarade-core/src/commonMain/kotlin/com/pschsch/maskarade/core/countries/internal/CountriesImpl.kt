package com.pschsch.maskarade.core.countries.internal

import com.pschsch.maskarade.core.countries.Countries
import com.pschsch.maskarade.core.countries.Country
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI


@OptIn(IncubatingMaskaradeAPI::class)
internal object CountriesImpl : Countries, Collection<Country> by createCountriesList()