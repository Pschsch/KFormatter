package com.pschsch.kformatter.core.masks.internal

import com.pschsch.kformatter.core.formatting.MaskFormatter
import com.pschsch.kformatter.core.formatting.builder.MaskFormatterBuilder
import com.pschsch.kformatter.core.formatting.builder.MaskFormatterBuilderImpl
import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal fun createFormatter(masks : List<Mask>, block : MaskFormatterBuilder.() -> Unit = {}): MaskFormatter {
    val builder = MaskFormatterBuilderImpl(masks)
    block(builder)
    return builder.build()
}