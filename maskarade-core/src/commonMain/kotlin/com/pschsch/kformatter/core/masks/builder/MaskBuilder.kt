package com.pschsch.kformatter.core.masks.builder

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingMaskaradeAPI

@IncubatingMaskaradeAPI
interface MaskBuilder {

    /**
     * Allows to append slot in a more shortened way:
     * 'D' - digit slot
     * 'L' - letter slot
     * all other chars - hardcoded slot
     * If you want to append 'D' or 'L' symbols as hardcoded symbols you should use [append] with [CharSequence] parameter and pass "\\D" or "\\L" escape sequence
     * */

    fun append(slotSymbol : Char): MaskBuilder

    fun append(slotSymbols : CharSequence): MaskBuilder

    fun append(slot: Mask.Slot): MaskBuilder

    fun append(vararg slots: Mask.Slot): MaskBuilder

    fun append(slots: Iterable<Mask.Slot>): MaskBuilder

    fun buildHint(mapBlock: (Int, Mask.Slot) -> Char): MaskBuilder

}