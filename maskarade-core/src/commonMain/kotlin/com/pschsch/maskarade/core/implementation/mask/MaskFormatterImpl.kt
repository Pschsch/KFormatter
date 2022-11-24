package com.pschsch.maskarade.core.implementation.mask

import com.pschsch.maskarade.core.api.mask.MaskFormatter
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
internal class MaskFormatterImpl(
    charSequence: CharSequence
) : MaskFormatter {

    override val mask = MaskImpl(MaskFormatParser.parse(charSequence))

}