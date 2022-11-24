package com.pschsch.maskarade.core.implementation.mask

import com.pschsch.maskarade.core.api.mask.Mask
import com.pschsch.maskarade.core.api.mask.MaskFormatter
import com.pschsch.maskarade.core.api.mask.MaskSlot
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
internal class MaskFormatterImpl(
    charSequence: CharSequence
) : MaskFormatter {

    override val mask: Mask = MaskImpl(MaskFormatParser.parse(charSequence))

}