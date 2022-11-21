package com.pschsch.maskarade.core.formatting

import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelable
import com.pschsch.maskarade.core.parcelable.Parcelize
import com.pschsch.maskarade.core.serializable.Serializable

@IncubatingMaskaradeAPI
interface MaskFormatter {

    @Parcelize
    sealed class CompletionState : Serializable, Parcelable {
        @Parcelize
        object NotCompleted : CompletionState()

        @Parcelize
        object Completed : CompletionState()

        @Parcelize
        object Overflow : CompletionState()
    }

    val masks : List<Mask>
    fun format(value : String): String

    fun isCompleted(value : String): CompletionState
}