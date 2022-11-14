package com.pschsch.kformatter.core.formatting.internal

import com.pschsch.kformatter.core.formatting.MaskFormatter
import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal class MaskFormatSession(
    private val masks: List<Mask>,
    private val valueToFormat: String,
    terminated: Boolean
) {

    class Result(
        val formattedValue: String,
        val completionState: MaskFormatter.CompletionState
    )

    private val valueCharQueue = ArrayDeque(valueToFormat.toMutableList())

    init {
        if (!terminated) TODO("Non-terminated formatting is not supported yet")
    }

    fun format(): Result {
        if (masks.isEmpty()) return Result(valueToFormat, MaskFormatter.CompletionState.NotCompleted)
        val mask = masks.first()
        if (mask.isEmpty()) return Result(valueToFormat, MaskFormatter.CompletionState.NotCompleted)
        val formattedString = StringBuilder()
        for (slot in mask) {
            when (slot) {
                is Mask.Slot.Hardcoded -> formattedString.append(slot.symbol)
                is Mask.Slot.Digit -> {
                    val symbol: Char = pickCharFromQueue { it.isDigit() }
                        ?: return Result(formattedString.toString(), MaskFormatter.CompletionState.NotCompleted)
                    formattedString.append(symbol)
                }

                is Mask.Slot.Letter -> {
                    val symbol: Char = pickCharFromQueue { it.isLetter() }
                        ?: return Result(formattedString.toString(), MaskFormatter.CompletionState.NotCompleted)
                    formattedString.append(symbol)
                }
            }
        }
        val state = if (valueCharQueue.isNotEmpty()) MaskFormatter.CompletionState.Overflow else MaskFormatter.CompletionState.Completed
        return Result(formattedString.toString(), state)
    }

    private fun pickCharFromQueue(predicate: (Char) -> Boolean): Char? {
        var symbol: Char = valueCharQueue.removeFirstOrNull() ?: return null
        while (!predicate(symbol)) {
            symbol = valueCharQueue.removeFirstOrNull() ?: return null
        }
        return symbol
    }

}