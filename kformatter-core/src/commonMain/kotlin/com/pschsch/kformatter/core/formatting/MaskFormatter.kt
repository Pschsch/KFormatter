package com.pschsch.kformatter.core.formatting

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
interface MaskFormatter {
    val mask : Mask
    fun format(value : String): String
}