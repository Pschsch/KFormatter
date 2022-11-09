package com.pschsch.kformatter.core.masks.internal

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.masks.builder.MaskBuilder
import com.pschsch.kformatter.core.masks.builder.internal.MaskBuilderImpl
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal fun createMask(block : MaskBuilder.() -> Unit): Mask {
    val builder = MaskBuilderImpl()
    block(builder)
    return builder.build()
}