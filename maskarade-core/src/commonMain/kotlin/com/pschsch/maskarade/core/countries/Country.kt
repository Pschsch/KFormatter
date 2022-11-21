package com.pschsch.maskarade.core.countries

import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.masks.factories.Mask
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelable
import com.pschsch.maskarade.core.serializable.Serializable

@IncubatingMaskaradeAPI
interface Country : Parcelable, Serializable {
    val isoCode : String
    val countryCode : String
    fun phoneMask(usingCountryCode : Boolean): Mask

}