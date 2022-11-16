@file:Suppress("NOTHING_TO_INLINE")

package com.pschsch.kformatter.core.countries

import com.pschsch.kformatter.core.optin.IncubatingMaskaradeAPI

@IncubatingMaskaradeAPI
inline fun Countries.findByCode(code: String): Country? = find { it.isoCode == code }

@IncubatingMaskaradeAPI
inline fun Countries.getByCode(code: String): Country =
    findByCode(code) ?: throw IllegalStateException("Country with code $code does not exists")