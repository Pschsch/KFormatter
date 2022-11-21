package com.pschsch.maskarade.core.formatting.internal

import com.pschsch.maskarade.core.formatting.MaskFormatter
import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
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