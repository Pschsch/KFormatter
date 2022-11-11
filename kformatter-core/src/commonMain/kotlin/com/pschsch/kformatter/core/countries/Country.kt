package com.pschsch.kformatter.core.countries

import com.pschsch.kformatter.core.countries.internal.CountryPhoneMaskImpl
import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import com.pschsch.kformatter.core.parcelable.Parcelable
import com.pschsch.kformatter.core.parcelable.Parcelize
import com.pschsch.kformatter.core.serializable.Serializable

@IncubatingKFormatterAPI
@Parcelize
class Country(
    val code: String,
    val phoneCode: String,
    private val codeAndMaskSeparator: Char,
    private val mask: String
) : Parcelable, Serializable {

    fun mask(withPhoneCode: Boolean): CountryPhoneMask {
        val mask = Mask.create {
            if (withPhoneCode) {
                append(phoneCode)
                append(codeAndMaskSeparator)
            }
            append(mask)
        }
        return CountryPhoneMaskImpl(mask)
    }
}