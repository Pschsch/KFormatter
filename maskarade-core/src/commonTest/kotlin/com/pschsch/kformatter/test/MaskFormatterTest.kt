package com.pschsch.kformatter.test

import com.pschsch.kformatter.core.countries.Countries
import com.pschsch.kformatter.core.countries.getByCode
import com.pschsch.kformatter.core.formatting.MaskFormatter
import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.masks.formatter
import com.pschsch.kformatter.core.optin.IncubatingMaskaradeAPI
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(IncubatingMaskaradeAPI::class)
class MaskFormatterTest {

    private val russianMaskWithPhoneCode = Countries.getByCode("ru").phoneMask(true)
    private val ukrainianMaskWithPhoneCode = Countries.getByCode("ua").phoneMask(true)
    private val ukrainianMaskWithoutPhoneCode = Countries.getByCode("ua").phoneMask(false)

    @Test
    fun testSimpleFormat() {
        val mask = Mask("12DDL345DL")
        val formatter = mask.formatter()
        val text = "12345"
        assertEquals("1212", formatter.format(text))
    }

    @Test
    fun testSimpleFormat2() {
        val mask = Mask("12DDL345DL")
        val formatter = mask.formatter()
        val text = "98Q123RTY"
        assertEquals("1298Q3451R", formatter.format(text))
    }

    @Test
    fun testSimpleFormat3() {
        val mask = Mask("+7 (DDD) DDD-DD-DD")
        val text = "79539871656"
        assertEquals("+7 (795) 398-71-65", mask.formatter().format(text))
    }

    @Test
    fun testSimpleFormat4() {
        val mask = Mask("+7 (DDD) DDD-DD-DD")
        val text = ""
        assertEquals("+7 (", mask.formatter().format(text))
    }

    @Test
    fun testSimpleFormat5() {
        val mask = Mask("+7 (DDD) DDD-DD-DD")
        val text = "953"
        assertEquals("+7 (953) ", mask.formatter().format(text))
    }

    @Test
    fun testSimpleFormat6() {
        val mask = Mask("+7 (DDD) DDD-DD-DD")
        val text = "99999999999999999999999"
        assertEquals("+7 (999) 999-99-99", mask.formatter().format(text))
    }

    @Test
    fun testRussianMaskFormat() {
        val text = "99999999999999999999999"
        assertEquals("+7 (999) 999-99-99", russianMaskWithPhoneCode.formatter().format(text))
    }

    @Test
    fun testUkrainianMaskFormat() {
        val text = "99999999999999999999999"
        assertEquals("+380 (99) 999-99-99", ukrainianMaskWithPhoneCode.formatter().format(text))
    }

    @Test
    fun testUkrainianMaskFormatWithoutPhoneCode() {
        val text = "99999999999999999999999"
        assertEquals("(99) 999-99-99", ukrainianMaskWithoutPhoneCode.formatter().format(text))
    }

    @Test
    fun testResultNotCompleted() {
        val formatter = russianMaskWithPhoneCode.formatter()
        val text = "953116"
        assertEquals(MaskFormatter.CompletionState.NotCompleted, formatter.isCompleted(text))
    }

    @Test
    fun testResultNotCompleted2() {
        val formatter = russianMaskWithPhoneCode.formatter()
        val text = "953someletters116"
        assertEquals(MaskFormatter.CompletionState.NotCompleted, formatter.isCompleted(text))
    }

    @Test
    fun testResultNotCompleted3() {
        val formatter = russianMaskWithPhoneCode.formatter()
        val text = ""
        assertEquals(MaskFormatter.CompletionState.NotCompleted, formatter.isCompleted(text))
    }

    @Test
    fun testResultCompleted() {
        val formatter = russianMaskWithPhoneCode.formatter()
        val text = "9531165656"
        assertEquals(MaskFormatter.CompletionState.Completed, formatter.isCompleted(text))
    }

    @Test
    fun testResultOverflow() {
        val formatter = russianMaskWithPhoneCode.formatter()
        val text = "95311656565"
        assertEquals(MaskFormatter.CompletionState.Overflow, formatter.isCompleted(text))
    }


}