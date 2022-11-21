package com.pschsch.maskarade.core.masks.factories.internal

import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.masks.factories.Mask
import com.pschsch.maskarade.core.masks.factories.MaskBuilder
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
internal fun createMask(block : MaskBuilder.() -> Unit): Mask {
    val builder = MaskBuilderImpl()
    block(builder)
    return builder.build()
}