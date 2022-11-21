package com.pschsch.maskarade.core.formatting.builder

import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI

@IncubatingMaskaradeAPI
interface MaskFormatterBuilder {

    fun terminated(value : Boolean = true)

}