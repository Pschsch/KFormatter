package com.pschsch.maskarade.core.masks.factories.internal

import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.masks.factories.Mask
import com.pschsch.maskarade.core.masks.factories.MaskBuilder
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
internal class MaskBuilderImpl : MaskBuilder {

    private val slots = mutableListOf<Mask.Slot>()
    private var hintBuilder : (Int, Mask.Slot) -> Char = { _, slot ->
        when (slot) {
            Mask.Slot.Digit -> '0'
            Mask.Slot.Letter -> '_'
            is Mask.Slot.Hardcoded -> slot.symbol
        }
    }

    override fun append(slotSymbol: Char): MaskBuilder {
        when (slotSymbol) {
            'D' -> append(Mask.Slot.Digit)
            'L' -> append(Mask.Slot.Letter)
            else -> append(Mask.Slot.Hardcoded(slotSymbol))
        }
        return this
    }

    override fun append(slotSymbols: CharSequence): MaskBuilder {
        var isLastEscapeCharacter = false
        for (symbol in slotSymbols) {
            if (symbol == '\\' && !isLastEscapeCharacter) {
                isLastEscapeCharacter = true
                continue
            }
            if (isLastEscapeCharacter && symbol == 'D') {
                append(Mask.Slot.Hardcoded('D'))
                isLastEscapeCharacter = false
                continue
            }
            if (isLastEscapeCharacter && symbol == 'L') {
                append(Mask.Slot.Hardcoded('L'))
                isLastEscapeCharacter = false
                continue
            }
            append(symbol)
        }
        return this
    }

    override fun append(slot: Mask.Slot): MaskBuilder {
        slots.add(slot)
        return this
    }

    override fun append(slots: Iterable<Mask.Slot>): MaskBuilder {
        this.slots.addAll(slots)
        return this
    }

    override fun append(vararg slots: Mask.Slot): MaskBuilder {
        this.slots.addAll(slots)
        return this
    }

    override fun buildHint(mapBlock: (Int, Mask.Slot) -> Char): MaskBuilder {
        hintBuilder = mapBlock
        return this
    }

    fun build() : Mask = MaskBuilderCreatedMask(slots, slots.mapIndexed(hintBuilder).joinToString(""))
}