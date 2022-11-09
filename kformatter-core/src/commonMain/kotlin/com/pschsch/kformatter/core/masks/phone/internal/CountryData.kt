package com.pschsch.kformatter.core.masks.phone.internal

import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
internal data class CountryData(
    val countryIsoCode: String,
    val countryPhoneCode: String,
    val codeAndMaskSeparator: Char,
    val mask: String
)

@OptIn(IncubatingKFormatterAPI::class)
internal val countryDataList
    get() = listOf(
        CountryData("az", "+994", ' ', "(DD) DDD-DD-DD"),
        CountryData("by", "+375", ' ', "(DD) DDD-DD-DD"),
        CountryData("kz", "+7", ' ', "(DDD) DDD-DD-DD"),
        CountryData("kg", "+996", ' ', "(DDD) DDD-DDD"),
        CountryData("ge", "+995", '-', "DDD-DDD-DDD"),
        CountryData("ru", "+7", ' ', "(DDD) DDD-DD-DD"),
        CountryData("ua", "+380", ' ', "(DD) DDD-DD-DD"),
        CountryData("us", "+1", '-', "DDD-DDD-DDDD"),
        CountryData("uz", "+998", ' ', "(DD) DDD-DD-DD"),
    )