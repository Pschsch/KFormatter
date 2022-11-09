package com.pschsch.kformatter.core.masks.builder.internal

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.masks.builder.MaskBuilder
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal class MaskBuilderImpl : MaskBuilder {

    private val slots = mutableListOf<Mask.Slot>()

    override fun append(slotSymbol: Char): MaskBuilder {
        when (slotSymbol) {
            'D' -> append(Mask.Slot.Digit)
            'L' -> append(Mask.Slot.Letter)
            else -> append(Mask.Slot.Hardcoded(slotSymbol))
        }
        return this
    }

    override fun append(slotSymbols: CharSequence): MaskBuilder {
        slotSymbols.forEach {
            append(it)
        }
        return this
    }

    override fun append(slot: Mask.Slot): MaskBuilder {
        slots.add(slot)
        return this
    }

    override fun append(slots: List<Mask.Slot>): MaskBuilder {
        this.slots.addAll(slots)
        return this
    }

    override fun append(vararg slots: Mask.Slot): MaskBuilder {
        this.slots.addAll(slots)
        return this
    }

    fun build() : Mask = MaskBuilderCreatedMask(slots)
}