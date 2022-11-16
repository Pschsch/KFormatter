package com.pschsch.kformatter.core.masks

import com.pschsch.kformatter.core.formatting.MaskFormatter
import com.pschsch.kformatter.core.formatting.builder.MaskFormatterBuilder
import com.pschsch.kformatter.core.masks.internal.createFormatter
import com.pschsch.kformatter.core.optin.IncubatingMaskaradeAPI
import com.pschsch.kformatter.core.parcelable.Parcelable
import com.pschsch.kformatter.core.parcelable.Parcelize
import com.pschsch.kformatter.core.serializable.Serializable

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