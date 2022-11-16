package com.pschsch.kformatter.core.countries

import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
inline fun Countries.findByCode(code: String): Country? = find { it.isoCode == code }

@IncubatingKFormatterAPI
inline fun Countries.getByCode(code: String): Country =
    findByCode(code) ?: throw IllegalStateException("Country with code $code does not exists")