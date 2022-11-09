package com.pschsch.kformatter.core.masks.phone.internal

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.masks.phone.PhoneMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal fun createPhoneMask(countryIsoCode: String, includeCountryCode: Boolean): PhoneMask {
    val countryData = countryDataList.associateBy { it.countryIsoCode }
    val country =
        countryData[countryIsoCode] ?: throw IllegalArgumentException("countryIsoCode $countryIsoCode does not exist")
    val countryCodeMaskPart =
        if (includeCountryCode) "${country.countryPhoneCode}${country.codeAndMaskSeparator}" else ""
    val actualMask = countryCodeMaskPart + country.mask
    val mask = Mask.create {
        append(actualMask)
    }
    return PhoneMaskImpl(mask, countryIsoCode, country.countryPhoneCode, mask.map {
        when (it) {
            Mask.Slot.Digit -> '0'
            Mask.Slot.Letter -> '_'
            is Mask.Slot.Hardcoded -> it.symbol
        }
    }.joinToString(""))
}