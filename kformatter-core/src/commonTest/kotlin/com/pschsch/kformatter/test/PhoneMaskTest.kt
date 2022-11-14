package com.pschsch.kformatter.test

import com.pschsch.kformatter.core.countries.Countries
import com.pschsch.kformatter.core.countries.getByCode
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(IncubatingKFormatterAPI::class)
class PhoneMaskTest {

    @Test
    fun testRussianMaskWithCountryCode() {
        val mask = Countries.default.getByCode("ru").phoneMask(true)
        assertEquals("+7 (000) 000-00-00", mask.hint)
    }

    @Test
    fun testRussianMaskWithoutCountryCode() {
        val mask = Countries.default.getByCode("ru").phoneMask(false)
        assertEquals("(000) 000-00-00", mask.hint)
    }

}