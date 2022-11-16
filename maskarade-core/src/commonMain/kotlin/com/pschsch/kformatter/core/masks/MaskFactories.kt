package com.pschsch.kformatter.core.masks

import com.pschsch.kformatter.core.masks.builder.MaskBuilder
import com.pschsch.kformatter.core.masks.internal.createMask
import com.pschsch.kformatter.core.optin.IncubatingMaskaradeAPI

@IncubatingMaskaradeAPI
fun Mask(block : MaskBuilder.() -> Unit): Mask  = createMask(block)

@IncubatingMaskaradeAPI
fun Mask(stringRepresentation: String): Mask = createMask {
    append(stringRepresentation)
}

@IncubatingMaskaradeAPI
fun Mask(fromSingleChar: Char): Mask = createMask {
    append(fromSingleChar)
}

@IncubatingMaskaradeAPI
fun Mask(slot: Mask.Slot): Mask = createMask {
    append(slot)
}

@IncubatingMaskaradeAPI
fun Mask(slots: Iterable<Mask.Slot>): Mask = createMask {
    append(slots)
}