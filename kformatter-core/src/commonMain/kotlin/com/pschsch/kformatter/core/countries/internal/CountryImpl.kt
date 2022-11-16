package com.pschsch.kformatter.core.countries.internal

import com.pschsch.kformatter.core.countries.Country
import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import com.pschsch.kformatter.core.parcelable.Parcelize

@IncubatingKFormatterAPI
@Parcelize
internal class CountryImpl(
    private val id : Int,
    override val isoCode: String,
    override val countryCode: String,
    private val codeAndMaskSeparator: Char,
    private val mask: String,
    private val englishName : String
) : Country {

    override fun phoneMask(usingCountryCode : Boolean): Mask {
        return Mask {
            val code = if (usingCountryCode) countryCode else null
            if (code != null) {
                append(code)
                append(codeAndMaskSeparator)
            }
            append(mask)
        }
    }

    override fun toString(): String {
        return "Country(code='$isoCode', phoneCode='$countryCode', englishName='$englishName')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false
        other as CountryImpl
        if (id != other.id) return false
        return true
    }

    override fun hashCode() = id


}