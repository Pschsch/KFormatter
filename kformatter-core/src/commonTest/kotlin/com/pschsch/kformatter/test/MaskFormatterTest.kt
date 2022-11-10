package com.pschsch.kformatter.test

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.masks.create
import com.pschsch.kformatter.core.masks.formatter
import com.pschsch.kformatter.core.masks.phone.PhoneMask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(IncubatingKFormatterAPI::class)
class MaskFormatterTest {

    @Test
    fun testSimpleFormat() {
        val mask = Mask.create("12DDL345DL")
        val formatter = mask.formatter()
        val text = "12345"
        assertEquals("1212", formatter.format(text))
    }

    @Test
    fun testSimpleFormat2() {
        val mask = Mask.create("12DDL345DL")
        val formatter = mask.formatter()
        val text = "98Q123RTY"
        assertEquals("1298Q3451", formatter.format(text))
    }

    @Test
    fun testSimpleFormat3() {
        val mask = Mask.create("+7 (DDD) DDD-DD-DD")
        val text = "79539871656"
        assertEquals("+7 (795) 398-71-65", mask.formatter().format(text))
    }

    @Test
    fun testSimpleFormat4() {
        val mask = Mask.create("+7 (DDD) DDD-DD-DD")
        val text = ""
        assertEquals("+7 (", mask.formatter().format(text))
    }

    @Test
    fun testSimpleFormat5() {
        val mask = Mask.create("+7 (DDD) DDD-DD-DD")
        val text = "953"
        assertEquals("+7 (953) ", mask.formatter().format(text))
    }

    @Test
    fun testSimpleFormat6() {
        val mask = Mask.create("+7 (DDD) DDD-DD-DD")
        val text = "99999999999999999999999"
        assertEquals("+7 (999) 999-99-99", mask.formatter().format(text))
    }

    @Test
    fun testRussianMaskFormat() {
        val mask = PhoneMask.create("ru", true)
        val text = "99999999999999999999999"
        assertEquals("+7 (999) 999-99-99", mask.formatter().format(text))
    }

    @Test
    fun testUkrainianMaskFormat() {
        val mask = PhoneMask.create("ua", true)
        val text = "99999999999999999999999"
        assertEquals("+380 (99) 999-99-99", mask.formatter().format(text))
    }

    @Test
    fun testUkrainianMaskFormatWithoutContryCode() {
        val mask = PhoneMask.create("ua", false)
        val text = "99999999999999999999999"
        assertEquals("(99) 999-99-99", mask.formatter().format(text))
    }



}