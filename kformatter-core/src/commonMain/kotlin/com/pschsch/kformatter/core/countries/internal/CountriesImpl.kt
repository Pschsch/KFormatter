package com.pschsch.kformatter.core.countries.internal

import com.pschsch.kformatter.core.countries.Countries
import com.pschsch.kformatter.core.countries.Country
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI


@OptIn(IncubatingKFormatterAPI::class)
internal class CountriesImpl(
    private val countriesList: List<Country> = createCountriesList()
) : Countries, Collection<Country> by countriesList

@OptIn(IncubatingKFormatterAPI::class)
private fun createCountriesList(): List<Country> {
    var id = 0
    fun createCountry(code : String, phoneCode : String, separator : Char, mask : String, englishName : String): Country {
        id += 1
        return Country(id, code, phoneCode, separator, mask, englishName)
    }
    return listOf(
        createCountry("az", "+994", ' ', "(DD) DDD-DD-DD", "Azerbaijan"),
        createCountry("by", "+375", ' ', "(DD) DDD-DD-DD", "Belarus"),
        createCountry("kz", "+7", ' ', "(DDD) DDD-DD-DD", "Kazakhstan"),
        createCountry("kg", "+996", ' ', "(DDD) DDD-DDD", "Kyrgyzstan"),
        createCountry("ge", "+995", '-', "DDD-DDD-DDD", "Georgia"),
        createCountry("md", "+373", ' ', "DDD DDD-DD", "Moldova"),
        createCountry("ru", "+7", ' ', "(DDD) DDD-DD-DD", "Russia"),
        createCountry("ua", "+380", ' ', "(DD) DDD-DD-DD", "Ukraine"),
        createCountry("us", "+1", '-', "DDD-DDD-DDDD", "U.S.A"),
        createCountry("uz", "+998", ' ', "(DD) DDD-DD-DD", "Uzbekistan"),
    )
}