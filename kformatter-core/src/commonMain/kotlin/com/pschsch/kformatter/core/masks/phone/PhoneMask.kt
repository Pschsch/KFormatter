package com.pschsch.kformatter.core.masks.phone

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.masks.phone.internal.createPhoneMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
interface PhoneMask : Mask {
    val countryIsoCode: String
    val countryCode: String
    val hint: String

    companion object {
        fun create(countryIsoCode: String, includeCountryCode: Boolean): PhoneMask =
            createPhoneMask(countryIsoCode, includeCountryCode)
    }
}