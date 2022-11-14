package com.pschsch.kformatter.core.formatting.internal

import com.pschsch.kformatter.core.formatting.MaskFormatter
import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal class MaskFormatterImpl(
    override val masks: List<Mask>,
    private val terminated : Boolean
) : MaskFormatter {

    override fun format(value: String): String {
        if (terminated) return formatTerminated(value).formattedValue else TODO("Non-terminated formatter is not supported")
    }

    override fun isCompleted(value: String): MaskFormatter.CompletionState {
        if (terminated) return formatTerminated(value).completionState else TODO("Non-terminated formatter is not supported")
    }

    private fun formatTerminated(value : String) = MaskFormatSession(masks, value, terminated).format()
}