package com.pschsch.kformatter.core.formatting.builder

import com.pschsch.kformatter.core.optin.IncubatingMaskaradeAPI

@IncubatingMaskaradeAPI
interface MaskFormatterBuilder {

    fun terminated(value : Boolean = true)

}