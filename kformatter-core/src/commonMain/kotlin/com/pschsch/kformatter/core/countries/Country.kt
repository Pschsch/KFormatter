package com.pschsch.kformatter.core.countries

import com.pschsch.kformatter.core.masks.Mask
import com.pschsch.kformatter.core.optin.IncubatingKFormatterAPI
import com.pschsch.kformatter.core.parcelable.Parcelable
import com.pschsch.kformatter.core.parcelable.Parcelize
import com.pschsch.kformatter.core.serializable.Serializable

@IncubatingKFormatterAPI
@Parcelize
class Country(
    private val id : Int,
    val code: String,
    val phoneCode: String,
    private val codeAndMaskSeparator: Char,
    private val mask: String,
    private val englishName : String
) : Parcelable, Serializable {

    fun phoneMask(withPhoneCode: Boolean): Mask {
        return Mask.create {
            if (withPhoneCode) {
                append(phoneCode)
                append(codeAndMaskSeparator)
            }
            append(mask)
        }
    }

    override fun toString(): String {
        return "Country(code='$code', phoneCode='$phoneCode', englishName='$englishName')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Country

        if (id != other.id) return false

        return true
    }

    override fun hashCode() = id


}