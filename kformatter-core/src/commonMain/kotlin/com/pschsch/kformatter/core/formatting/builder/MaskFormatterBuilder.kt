package com.pschsch.kformatter.core.formatting.builder

import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@IncubatingKFormatterAPI
interface MaskFormatterBuilder {

    fun terminated(value : Boolean = true)

}