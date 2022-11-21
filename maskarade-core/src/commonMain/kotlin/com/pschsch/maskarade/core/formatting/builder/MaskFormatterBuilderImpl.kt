package com.pschsch.maskarade.core.formatting.builder

import com.pschsch.maskarade.core.formatting.MaskFormatter
import com.pschsch.maskarade.core.formatting.internal.MaskFormatterImpl
import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI

@OptIn(IncubatingMaskaradeAPI::class)
internal class MaskFormatterBuilderImpl(
    val masks : List<Mask>
) : MaskFormatterBuilder {

    private var terminated = true

    override fun terminated(value: Boolean) {
        terminated = value
    }

    fun build() : MaskFormatter {
        return MaskFormatterImpl(masks, terminated)
    }

}