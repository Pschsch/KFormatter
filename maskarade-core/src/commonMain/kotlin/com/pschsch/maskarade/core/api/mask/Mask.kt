package com.pschsch.maskarade.core.api.mask

import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI
import com.pschsch.maskarade.core.parcelable.Parcelable
import com.pschsch.maskarade.core.serializable.Serializable

@IncubatingMaskaradeAPI
interface Mask : Collection<MaskSlot>, Parcelable, Serializable {
    companion object
}