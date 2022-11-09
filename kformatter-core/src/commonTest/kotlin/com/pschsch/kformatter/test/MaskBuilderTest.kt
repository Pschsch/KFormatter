package com.pschsch.kformatter.test

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(IncubatingKFormatterAPI::class)
class MaskBuilderTest {

    @Test
    fun testBuiltSlots() {
        val mask = Mask.create {
            append('+')
            append('7')
            append("DDD-116")
            append("56")
            append('5')
            append("6")
        }
        assertEquals(listOf(
            Mask.Slot.Hardcoded('+'),
            Mask.Slot.Hardcoded('7'),
            Mask.Slot.Digit,
            Mask.Slot.Digit,
            Mask.Slot.Digit,
            Mask.Slot.Hardcoded('-'),
            Mask.Slot.Hardcoded('1'),
            Mask.Slot.Hardcoded('1'),
            Mask.Slot.Hardcoded('6'),
            Mask.Slot.Hardcoded('5'),
            Mask.Slot.Hardcoded('6'),
            Mask.Slot.Hardcoded('5'),
            Mask.Slot.Hardcoded('6'),
        ), mask.toList())
    }

    @Test
    fun testBuiltSlotsWithEscapeSequenceLength() {
        val mask = Mask.create {
            append("\\D37")
        }
        assertEquals(4, mask.count())
    }

    @Test
    fun testBuiltSlotsWithEscapeSequence() {
        val mask = Mask.create {
            append("\\D37D\\L\\D")
        }
        assertEquals(listOf(
            Mask.Slot.Hardcoded('D'),
            Mask.Slot.Hardcoded('3'),
            Mask.Slot.Hardcoded('7'),
            Mask.Slot.Digit,
            Mask.Slot.Hardcoded('L'),
            Mask.Slot.Hardcoded('D'),
        ), mask.toList())
    }



}