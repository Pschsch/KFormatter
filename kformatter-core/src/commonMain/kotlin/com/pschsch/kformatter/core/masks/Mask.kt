package com.pschsch.kformatter.core.masks

import com.pschsch.kformatter.core.masks.builder.MaskBuilder
import com.pschsch.kformatter.core.masks.internal.createMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import com.pschsch.kformatter.core.parcelable.Parcelable
import com.pschsch.kformatter.core.parcelable.Parcelize
import com.pschsch.kformatter.core.serializable.Serializable

@IncubatingKFormatterAPI
interface Mask : Iterable<Mask.Slot>, Parcelable, Serializable {

    @Parcelize
    sealed class Slot : Parcelable, Serializable {
        @Parcelize
        object Digit : Slot()
        @Parcelize
        object Letter : Slot()
        @Parcelize
        data class Hardcoded(val symbol: Char) : Slot()
    }

    companion object {
        fun create(block: MaskBuilder.() -> Unit): Mask = createMask(block)
        fun create(stringRepresentation : String): Mask = create {
            append(stringRepresentation)
        }
    }

}