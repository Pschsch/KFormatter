package com.pschsch.maskarade.core.masks.factories

import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.masks.factories.internal.createMask
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI

@IncubatingMaskaradeAPI
fun Mask(block : MaskBuilder.() -> Unit): Mask = createMask(block)

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