package com.pschsch.kformatter.core.masks

import com.pschsch.kformatter.core.masks.builder.MaskBuilder
import com.pschsch.kformatter.core.masks.internal.createMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
fun Mask(block : MaskBuilder.() -> Unit): Mask  = createMask(block)

@IncubatingKFormatterAPI
fun Mask(stringRepresentation: String): Mask = createMask {
    append(stringRepresentation)
}

@IncubatingKFormatterAPI
fun Mask(fromSingleChar: Char): Mask = createMask {
    append(fromSingleChar)
}

@IncubatingKFormatterAPI
fun Mask(slot: Mask.Slot): Mask = createMask {
    append(slot)
}

@IncubatingKFormatterAPI
fun Mask(slots: Iterable<Mask.Slot>): Mask = createMask {
    append(slots)
}