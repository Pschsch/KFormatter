package com.pschsch.kformatter.core.countries.internal

import com.pschsch.kformatter.core.countries.Countries
import com.pschsch.kformatter.core.countries.Country
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI


@OptIn(IncubatingKFormatterAPI::class)
object CountriesImpl : Countries, Collection<Country> by createCountriesList()