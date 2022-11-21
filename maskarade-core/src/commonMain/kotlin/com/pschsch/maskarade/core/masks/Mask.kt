package com.pschsch.maskarade.core.masks

import com.pschsch.maskarade.core.formatting.MaskFormatter
import com.pschsch.maskarade.core.formatting.builder.MaskFormatterBuilder
import com.pschsch.maskarade.core.masks.internal.createFormatter
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelable
import com.pschsch.maskarade.core.parcelable.Parcelize
import com.pschsch.maskarade.core.serializable.Serializable

@IncubatingMaskaradeAPI
interface Mask : Collection<Mask.Slot>, Parcelable, Serializable {

    val hint : String

    @Parcelize
    sealed class Slot : Parcelable, Serializable {
        @Parcelize
        object Digit : Slot()

        @Parcelize
        object Letter : Slot()

        @Parcelize
        data class Hardcoded(val symbol: Char) : Slot()
    }
    companion object
}

@IncubatingMaskaradeAPI
fun Mask.formatter(block : MaskFormatterBuilder.() -> Unit = {}): MaskFormatter = createFormatter(listOf(this), block)

@IncubatingMaskaradeAPI
fun List<Mask>.formatter(block : MaskFormatterBuilder.() -> Unit = {}): MaskFormatter = createFormatter(this, block)