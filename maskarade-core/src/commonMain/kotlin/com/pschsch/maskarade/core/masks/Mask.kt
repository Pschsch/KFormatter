package com.pschsch.maskarade.core.masks

import com.pschsch.maskarade.core.formatting.MaskFormatter
import com.pschsch.maskarade.core.formatting.builder.MaskFormatterBuilder
import com.pschsch.maskarade.core.formatting.internal.createFormatter
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelable
import com.pschsch.maskarade.core.parcelable.Parcelize
import com.pschsch.maskarade.core.serializable.Serializable

@IncubatingMaskaradeAPI
interface Mask : Collection<Mask.Slot>, Parcelable, Serializable {
    @Parcelize
    sealed class Slot : Parcelable, Serializable {
        @Parcelize
        object Digit : Slot() {
            override fun toString(): String {
                return "Digit"
            }
        }

        @Parcelize
        object Letter : Slot() {
            override fun toString(): String {
                return "Letter"
            }
        }

        @Parcelize
        data class Hardcoded(val symbol: Char) : Slot()
    }

    val hint : String

    companion object
}

@IncubatingMaskaradeAPI
fun Mask.formatter(block : MaskFormatterBuilder.() -> Unit = {}): MaskFormatter = createFormatter(listOf(this), block)

@IncubatingMaskaradeAPI
fun List<Mask>.formatter(block : MaskFormatterBuilder.() -> Unit = {}): MaskFormatter = createFormatter(this, block)