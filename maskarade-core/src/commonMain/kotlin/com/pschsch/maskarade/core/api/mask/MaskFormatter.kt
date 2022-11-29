package com.pschsch.maskarade.core.api.mask

import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI

/**
 * Transforms char sequence format into collection of [MaskSlot].
 * MaskSlot's patterns describes at [MaskSlot]
 * */

@IncubatingMaskaradeAPI
interface MaskFormatter {

    val mask: Mask

}