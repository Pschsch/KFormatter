package com.pschsch.maskarade.test

import com.pschsch.maskarade.core.api.mask.MaskSlot
import com.pschsch.maskarade.core.api.mask.factories.MaskFormatter
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(IncubatingMaskaradeAPI::class)
class MaskFormatterTest {

    @Test
    fun simpleTest() {
        val slots = MaskFormatter("DD.DD.DD").mask
        assertEquals(listOf(
            MaskSlot.Digit,
            MaskSlot.Digit,
            MaskSlot.Char('.'),
            MaskSlot.Digit,
            MaskSlot.Digit,
            MaskSlot.Char('.'),
            MaskSlot.Digit,
            MaskSlot.Digit,
        ), slots.toList())
    }

    @Test
    fun escapeTest() {
        val slots = MaskFormatter("\\DJ дай").mask
        assertEquals(listOf(
            MaskSlot.Char('D'),
            MaskSlot.Char('J'),
            MaskSlot.Char(' '),
            MaskSlot.Char('д'),
            MaskSlot.Char('а'),
            MaskSlot.Char('й'),
        ), slots.toList())
    }

    @Test
    fun escapeTest2() {
        val slots = MaskFormatter("\\DJ дай\\\\").mask
        assertEquals(listOf(
            MaskSlot.Char('D'),
            MaskSlot.Char('J'),
            MaskSlot.Char(' '),
            MaskSlot.Char('д'),
            MaskSlot.Char('а'),
            MaskSlot.Char('й'),
            MaskSlot.Char('\\'),
        ), slots.toList())
    }

}