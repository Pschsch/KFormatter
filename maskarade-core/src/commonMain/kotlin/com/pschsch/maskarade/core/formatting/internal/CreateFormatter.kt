package com.pschsch.maskarade.core.formatting.internal

import com.pschsch.maskarade.core.formatting.MaskFormatter
import com.pschsch.maskarade.core.formatting.builder.MaskFormatterBuilder
import com.pschsch.maskarade.core.formatting.builder.MaskFormatterBuilderImpl
import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.masks.factories.Mask
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
internal fun createFormatter(masks : List<Mask>, block : MaskFormatterBuilder.() -> Unit = {}): MaskFormatter {
    val builder = MaskFormatterBuilderImpl(masks)
    block(builder)
    return builder.build()
}