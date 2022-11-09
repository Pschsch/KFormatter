package com.pschsch.kformatter.core.masks

import com.pschsch.kformatter.core.masks.builder.MaskBuilder
import com.pschsch.kformatter.core.masks.builder.internal.MaskBuilderImpl
import com.pschsch.kformatter.core.masks.internal.createMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
interface Mask : Iterable<Mask.Slot> {

    sealed class Slot {
        data object Digit : Slot()
        data object Letter : Slot()
        data class Hardcoded(val symbol: Char) : Slot()
    }

    companion object {
        fun create(block : MaskBuilder.() -> Unit): Mask = createMask(block)
    }

}