package com.pschsch.maskarade.core.implementation.mask

import com.pschsch.maskarade.core.api.mask.Mask
import com.pschsch.maskarade.core.api.mask.MaskSlot
import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelize

@OptIn(IncubatingMaskaradeAPI::class)
@Parcelize
internal data class MaskImpl(
    private val slots: List<MaskSlot>
) : Mask, Collection<MaskSlot> by slots