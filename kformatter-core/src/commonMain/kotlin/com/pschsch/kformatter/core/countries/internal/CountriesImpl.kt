package com.pschsch.kformatter.core.countries.internal

import com.pschsch.kformatter.core.countries.Countries
import com.pschsch.kformatter.core.countries.Country
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI


@OptIn(IncubatingKFormatterAPI::class)
internal class CountriesImpl(
    private val countriesList: List<Country> = listOf(
        Country("az", "+994", ' ', "(DD) DDD-DD-DD"),
        Country("by", "+375", ' ', "(DD) DDD-DD-DD"),
        Country("kz", "+7", ' ', "(DDD) DDD-DD-DD"),
        Country("kg", "+996", ' ', "(DDD) DDD-DDD"),
        Country("md", "+373", ' ', "DDD DDD-DD"),
        Country("ge", "+995", '-', "DDD-DDD-DDD"),
        Country("ru", "+7", ' ', "(DDD) DDD-DD-DD"),
        Country("ua", "+380", ' ', "(DD) DDD-DD-DD"),
        Country("us", "+1", '-', "DDD-DDD-DDDD"),
        Country("uz", "+998", ' ', "(DD) DDD-DD-DD"),
    )
) : Countries, Collection<Country> by countriesList