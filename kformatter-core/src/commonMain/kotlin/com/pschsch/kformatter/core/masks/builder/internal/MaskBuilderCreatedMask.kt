package com.pschsch.kformatter.core.masks.builder.internal

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import com.pschsch.kformatter.core.parcelable.Parcelize

@OptIn(IncubatingKFormatterAPI::class)
@Parcelize
internal class MaskBuilderCreatedMask(private val slots: List<Mask.Slot>) : Mask, Iterable<Mask.Slot> by slots