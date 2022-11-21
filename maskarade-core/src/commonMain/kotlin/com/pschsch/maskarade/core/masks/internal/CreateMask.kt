package com.pschsch.maskarade.core.masks.internal

import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.masks.builder.MaskBuilder
import com.pschsch.maskarade.core.masks.builder.internal.MaskBuilderImpl
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
internal fun createMask(block : MaskBuilder.() -> Unit): Mask {
    val builder = MaskBuilderImpl()
    block(builder)
    return builder.build()
}