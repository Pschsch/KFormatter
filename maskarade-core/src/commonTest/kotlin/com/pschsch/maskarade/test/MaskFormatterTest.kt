package com.pschsch.maskarade.test

import com.pschsch.maskarade.core.api.mask.factories.MaskFormatter
import com.pschsch.maskarade.core.api.mask.matches
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

@OptIn(IncubatingMaskaradeAPI::class)
class MaskFormatterTest {

    @Test
    fun testMatchingFormat1() {
        val mask = MaskFormatter("[0-3]D.[0-1]D.202[2-5]").mask
        assertTrue("23.11.2023".matches(mask))
        assertTrue("01.15.2022".matches(mask))
        assertFalse("11.09.2021".matches(mask))
    }

    @Test
    fun testMaskFormatterValidation() {
        fun exceptionMessage(sequence: CharSequence) = "Invalid sequence detected in provided format: $sequence"
        val message1 = getValidationExceptionMessage("[0-3]D.[0-1]D.202[2-5]")
        val message2 = getValidationExceptionMessage("[lS]?squisqui[SLC]?")
        val message3 = getValidationExceptionMessage("[lS]?squisqui[LCS]!")
        assertEquals(null, message1)
        assertEquals(null, message2)
        assertEquals(exceptionMessage("[LCS]!"), message3)
    }

    private fun getValidationExceptionMessage(sequence: CharSequence): String? {
        return try {
            MaskFormatter(sequence)
            null
        } catch (e: IllegalStateException) {
            e.message
        }
    }


}