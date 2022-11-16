package com.pschsch.kformatter.core.countries

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import com.pschsch.kformatter.core.parcelable.Parcelable
import com.pschsch.kformatter.core.serializable.Serializable

@IncubatingKFormatterAPI
interface Country : Parcelable, Serializable {
    val isoCode : String
    val countryCode : String
    fun phoneMask(usingCountryCode : Boolean): Mask

}