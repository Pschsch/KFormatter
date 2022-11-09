package com.pschsch.kformatter.core.masks.phone.internal

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.masks.phone.PhoneMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal class PhoneMaskImpl(
    private val slots: Iterable<Mask.Slot>,
    override val countryIsoCode: String,
    override val countryCode: String,
    override val hint: String
) : PhoneMask, Iterable<Mask.Slot> by slots