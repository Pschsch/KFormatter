package com.pschsch.maskarade.core.implementation.mask

import com.pschsch.maskarade.core.api.mask.MaskFormatter
import com.pschsch.maskarade.core.api.mask.MaskSlot
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
internal class MaskFormatterImpl(
    charSequence: CharSequence
) : MaskFormatter {

    override val slots: List<MaskSlot> = MaskFormatParser.parse(charSequence)

}