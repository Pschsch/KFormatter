package com.pschsch.maskarade.core.api.mask

import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelable
import com.pschsch.maskarade.core.parcelable.Parcelize
import com.pschsch.maskarade.core.serializable.Serializable

/**
 * Describes available values in every slot of formatting string
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
    data class Charset(val value : List<kotlin.Char>): MaskSlot()

    @Parcelize
    data class CharRange(val start : kotlin.Char, val end : kotlin.Char): MaskSlot()

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

    @Parcelize
    data class AnyMatching(val slots : List<MaskSlot>): MaskSlot()

    @Parcelize
    data class AllMatching(val slots : List<MaskSlot>): MaskSlot()

}