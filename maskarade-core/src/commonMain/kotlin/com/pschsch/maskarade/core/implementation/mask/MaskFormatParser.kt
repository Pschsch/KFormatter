package com.pschsch.maskarade.core.implementation.mask

import com.pschsch.maskarade.core.api.mask.MaskSlot
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
internal object MaskFormatParser {

    fun parse(charSequence: CharSequence): List<MaskSlot> {
        if (charSequence.isEmpty()) return emptyList()
        if (charSequence.length == 1) return listOf(slotFromSingleChar(charSequence.first()))
        val deque = ArrayDeque(charSequence.toList())
        val slots = mutableListOf<MaskSlot>()
        var element = deque.removeFirstOrNull()
        var isEscapeSymbol = false
        while (element != null) {
            if (isEscapeSymbol) {
                slots.add(MaskSlot.Char(element))
                isEscapeSymbol = false
                element = deque.removeFirstOrNull()
            } else if (element == '\\') {
                isEscapeSymbol = true
                element = deque.removeFirstOrNull()
            } else {
                val slot = slotFromSingleChar(element)
                slots.add(slot)
                element = deque.removeFirstOrNull()
            }
        }
        return slots
    }

    private fun slotFromSingleChar(char: Char): MaskSlot {
        return when(char) {
            'D' -> MaskSlot.Digit
            'L' -> MaskSlot.UppercaseLetter
            'l' -> MaskSlot.LowercaseLetter
            'S' -> MaskSlot.LatinLetter
            'C' -> MaskSlot.CyrillicLetter
            else -> MaskSlot.Char(char)
        }
    }

}