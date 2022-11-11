package com.pschsch.kformatter.core.countries

import com.pschsch.kformatter.core.countries.internal.CountriesImpl
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
interface Countries : Iterable<Country> {
    companion object {
        val default : Countries = CountriesImpl()
    }
}

@IncubatingKFormatterAPI
inline fun Countries.findByCode(code : String): Country? = find { it.code == code }

@IncubatingKFormatterAPI
inline fun Countries.getByCode(code: String): Country = findByCode(code) ?: throw IllegalStateException("Country with code $code does not exists")