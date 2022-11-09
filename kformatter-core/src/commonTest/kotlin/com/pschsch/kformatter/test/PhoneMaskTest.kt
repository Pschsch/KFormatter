package com.pschsch.kformatter.test

import com.pschsch.kformatter.core.masks.phone.PhoneMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(IncubatingKFormatterAPI::class)
class PhoneMaskTest {

    @Test
    fun testRussianMaskWithCountryCode() {
        val mask = PhoneMask.create("ru", true)
        assertEquals("+7 (000) 000-00-00", mask.hint)
    }

    @Test
    fun testRussianMaskWithoutCountryCode() {
        val mask = PhoneMask.create("ru", false)
        assertEquals("(000) 000-00-00", mask.hint)
    }

}