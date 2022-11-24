package com.pschsch.maskarade.core.api.countries

import com.pschsch.maskarade.core.api.mask.Mask
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelable
import com.pschsch.maskarade.core.serializable.Serializable

@IncubatingMaskaradeAPI
interface Country : Parcelable, Serializable {
    val isoCode : String
    val countryCode : String
    fun phoneMask(usingCountryCode : Boolean): Mask

}