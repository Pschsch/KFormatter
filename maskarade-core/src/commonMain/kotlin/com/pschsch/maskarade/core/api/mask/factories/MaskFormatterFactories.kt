package com.pschsch.maskarade.core.api.mask.factories

import com.pschsch.maskarade.core.api.mask.MaskFormatter
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.implementation.mask.MaskFormatterImpl

@IncubatingMaskaradeAPI
fun MaskFormatter(charSequence: CharSequence): MaskFormatter {
    return MaskFormatterImpl(charSequence)
}

@IncubatingMaskaradeAPI
fun MaskFormatter(char: Char): MaskFormatter {
    return MaskFormatterImpl(char.toString())
}