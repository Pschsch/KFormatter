package com.pschsch.kformatter.core.masks

import com.pschsch.kformatter.core.masks.builder.MaskBuilder
import com.pschsch.kformatter.core.masks.internal.createMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import com.pschsch.kformatter.core.platform.Parcelable
import com.pschsch.kformatter.core.platform.Parcelize
import com.pschsch.kformatter.core.platform.Serializable

@IncubatingKFormatterAPI
interface Mask : Iterable<Mask.Slot>, Parcelable, Serializable {

    @Parcelize
    sealed class Slot : Parcelable, Serializable {
        object Digit : Slot()
        object Letter : Slot()
        data class Hardcoded(val symbol: Char) : Slot()
    }

    companion object {
        fun create(block: MaskBuilder.() -> Unit): Mask = createMask(block)
    }

}