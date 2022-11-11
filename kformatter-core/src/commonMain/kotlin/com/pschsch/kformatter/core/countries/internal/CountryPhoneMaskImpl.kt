package com.pschsch.kformatter.core.countries.internal

import com.pschsch.kformatter.core.countries.CountryPhoneMask
import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import com.pschsch.kformatter.core.parcelable.Parcelize

@OptIn(IncubatingKFormatterAPI::class)
@Parcelize
internal class CountryPhoneMaskImpl(
    private val mask : Mask
) : CountryPhoneMask, Collection<Mask.Slot> by mask {

    override val hint: String
        get() = mask.map {
            when (it) {
                Mask.Slot.Digit -> '0'
                Mask.Slot.Letter -> '_'
                is Mask.Slot.Hardcoded -> it.symbol
            }
        }.joinToString("")
}