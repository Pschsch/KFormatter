package com.pschsch.kformatter.core.formatting.internal

import com.pschsch.kformatter.core.formatting.MaskFormatter
import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal class MaskFormatterImpl(
    override val mask: Mask,
    private val terminated : Boolean
) : MaskFormatter {

    override fun format(value: String): String {
        if (terminated) return formatTerminated(value) else TODO("Non-terminated formatter is not supported")
    }

    private fun formatTerminated(value : String) : String {
        val valueCharSet = ArrayDeque(value.toMutableList())
        var nonMatching = false
        return mask.mapNotNull {
            if (nonMatching) return@mapNotNull null
            when (it) {
                is Mask.Slot.Digit -> {
                    if (valueCharSet.isEmpty()) {
                        nonMatching = true
                        return@mapNotNull null
                    }
                    if (!valueCharSet.first().isDigit()) {
                        nonMatching = true
                        return@mapNotNull null
                    }
                    if (valueCharSet.first().isDigit()) valueCharSet.removeFirst() else  null
                }
                is Mask.Slot.Hardcoded -> it.symbol
                is Mask.Slot.Letter -> {
                    if (valueCharSet.isEmpty()) {
                        nonMatching = true
                        return@mapNotNull null
                    }
                    if (!valueCharSet.first().isLetter()) {
                        nonMatching = true
                        return@mapNotNull null
                    }
                    if (valueCharSet.first().isLetter()) valueCharSet.removeFirst() else  null
                }
            }
        }.joinToString("")
    }
}