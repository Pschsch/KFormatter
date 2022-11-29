package com.pschsch.maskarade.core.api.mask

import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelable
import com.pschsch.maskarade.core.parcelable.Parcelize
import com.pschsch.maskarade.core.serializable.Serializable

/**
 * Describes available values in every slot of formatting string
 * MaskSlot objects can be represented via patterns.
 * Symbol patterns contain only one symbol.
 *
 * MaskSlot symbol patterns:
 * [MaskSlot.Digit] -> D
 * [MaskSlot.LatinLetter] -> S
 * [MaskSlot.CyrillicLetter] -> C
 * [MaskSlot.LowercaseLetter] -> l
 * [MaskSlot.UppercaseLetter] -> L
 * [MaskSlot.Char] -> any other symbol, different from listed above
 * To represent symbol pattern as [MaskSlot.Char], use escaping:
 * \\L matches [MaskSlot.Char] with 'L' value
 *
 * */

@IncubatingMaskaradeAPI
@Parcelize
sealed class MaskSlot : Parcelable, Serializable {

    @Parcelize
    object Digit : MaskSlot() {
        override fun toString(): String {
            return "Digit"
        }
    }

    @Parcelize
    data class Char(val value : kotlin.Char): MaskSlot()

    @Parcelize
    object UppercaseLetter : MaskSlot() {
        override fun toString() = "UppercaseLetter"
    }

    @Parcelize
    object LowercaseLetter : MaskSlot() {
        override fun toString() = "LowercaseLetter"
    }

    @Parcelize
    object LatinLetter : MaskSlot() {
        override fun toString() = "LatinLetter"
    }

    @Parcelize
    object CyrillicLetter : MaskSlot() {
        override fun toString() = "CyrillicLetter"
    }

}