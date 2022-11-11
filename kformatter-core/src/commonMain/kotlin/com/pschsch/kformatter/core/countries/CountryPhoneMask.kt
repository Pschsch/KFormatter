package com.pschsch.kformatter.core.countries

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
interface CountryPhoneMask : Mask {
    val hint : String
}