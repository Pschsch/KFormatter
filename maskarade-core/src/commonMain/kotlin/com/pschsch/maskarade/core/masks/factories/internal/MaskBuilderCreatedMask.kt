package com.pschsch.maskarade.core.masks.factories.internal

import com.pschsch.maskarade.core.masks.Mask
import com.pschsch.maskarade.core.masks.factories.Mask
import com.pschsch.maskarade.core.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelize

@OptIn(IncubatingMaskaradeAPI::class)
@Parcelize
internal data class MaskBuilderCreatedMask(
    private val slots: List<Mask.Slot>,
    override val hint: String
) : Mask, Collection<Mask.Slot> by slots