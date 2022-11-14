package com.pschsch.kformatter.core.masks

import com.pschsch.kformatter.core.formatting.MaskFormatter
import com.pschsch.kformatter.core.formatting.builder.MaskFormatterBuilder
import com.pschsch.kformatter.core.formatting.builder.MaskFormatterBuilderImpl
import com.pschsch.kformatter.core.masks.builder.MaskBuilder
import com.pschsch.kformatter.core.masks.internal.createMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import com.pschsch.kformatter.core.parcelable.Parcelable
import com.pschsch.kformatter.core.parcelable.Parcelize
import com.pschsch.kformatter.core.serializable.Serializable

@IncubatingKFormatterAPI
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

    companion object {
        fun create(block: MaskBuilder.() -> Unit): Mask = createMask(block)
    }

}

@IncubatingKFormatterAPI
fun Mask.Companion.create(stringRepresentation: String) = create {
    append(stringRepresentation)
}

@IncubatingKFormatterAPI
fun Mask.Companion.create(fromSingleChar : Char) = create {
    append(fromSingleChar)
}

@IncubatingKFormatterAPI
fun Mask.Companion.create(slot : Mask.Slot) = create {
    append(slot)
}

@IncubatingKFormatterAPI
fun Mask.Companion.create(slots : Iterable<Mask.Slot>) = create {
    append(slots)
}

@IncubatingKFormatterAPI
fun Mask.formatter(block : MaskFormatterBuilder.() -> Unit = {}): MaskFormatter = formatterImpl(listOf(this), block)

@IncubatingKFormatterAPI
fun List<Mask>.formatter(block : MaskFormatterBuilder.() -> Unit = {}): MaskFormatter = formatterImpl(this, block)

@OptIn(IncubatingKFormatterAPI::class)
private fun formatterImpl(masks : List<Mask>, block : MaskFormatterBuilder.() -> Unit = {}): MaskFormatter {
    val builder = MaskFormatterBuilderImpl(masks)
    block(builder)
    return builder.build()
}