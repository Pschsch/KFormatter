package com.pschsch.kformatter.core.formatting.builder

import com.pschsch.kformatter.core.formatting.MaskFormatter
import com.pschsch.kformatter.core.formatting.internal.MaskFormatterImpl
import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal class MaskFormatterBuilderImpl(
    val mask : Mask
) : MaskFormatterBuilder {

    private var terminated = true

    override fun terminated(value: Boolean) {
        terminated = value
    }

    fun build() : MaskFormatter {
        return MaskFormatterImpl(mask, terminated)
    }

}