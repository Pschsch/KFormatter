package com.pschsch.maskarade.core.implementation.countries

import com.pschsch.maskarade.core.api.countries.Country
import com.pschsch.maskarade.core.api.mask.Mask
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelize

@IncubatingMaskaradeAPI
@Parcelize
internal class CountryImpl(
    private val id: Int,
    override val isoCode: String,
    override val countryCode: String,
    private val codeAndMaskSeparator: Char,
    private val mask: String,
    private val englishName: String
) : Country {

    private val countryCodeMask: Mask by lazy {
        TODO()
    }

    private val noCountryCodeMask: Mask by lazy {
        TODO()
    }

    override fun phoneMask(usingCountryCode: Boolean): Mask {
        return if (usingCountryCode) countryCodeMask else noCountryCodeMask
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