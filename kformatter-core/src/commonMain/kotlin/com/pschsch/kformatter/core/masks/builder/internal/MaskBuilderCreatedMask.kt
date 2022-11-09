package com.pschsch.kformatter.core.masks.builder.internal

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI

@OptIn(IncubatingKFormatterAPI::class)
internal class MaskBuilderCreatedMask(slots: List<Mask.Slot>) : Mask, Iterable<Mask.Slot> by slots