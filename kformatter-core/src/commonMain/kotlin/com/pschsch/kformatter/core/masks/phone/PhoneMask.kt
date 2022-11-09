package com.pschsch.kformatter.core.masks.phone

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.masks.phone.internal.buildPhoneMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
interface PhoneMask : Mask {
    val countryIsoCode: String
    val countryCode: String
    val hint : String
}

@IncubatingKFormatterAPI
fun PhoneMask(countryIsoCode: String, includeCountryCode: Boolean): PhoneMask {
    return buildPhoneMask(countryIsoCode, includeCountryCode)
}