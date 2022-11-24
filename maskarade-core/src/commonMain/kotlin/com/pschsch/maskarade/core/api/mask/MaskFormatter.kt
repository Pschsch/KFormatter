package com.pschsch.maskarade.core.api.mask

import com.pschsch.maskarade.core.api.optin.IncubatingMaskaradeAPI

/**
 * Transforms char sequence format into collection of [MaskSlot].
 * String slots representation described via slot symbol's:
 * D - [MaskSlot.Digit]
 * l - [MaskSlot.LowercaseLetter]
 * L - [MaskSlot.UppercaseLetter]
 * S - [MaskSlot.LatinLetter]
 * C - [MaskSlot.CyrillicLetter]
 * []? - [MaskSlot.AnyMatching]
 * @sample: [Ll]? will match to both uppercase and lowercase letter
 * []! - [MaskSlot.AllMatching]
 * @sample: [SL]! will match to uppercase latin letter
 * Be aware that possible combinations are restricted.
 * For instance, you can not use format [CS]! because there are no letter which will be cyrillic and latin at the same time
 * [] - [MaskSlot.Charset]
 * @sample: [123456] will match to some of enumerated characters. Can not be mixed with slot symbols
 * [-] - [MaskSlot.CharRange]
 * @sample: [1-6] with match to characters at range from 1 to 6 (all-inclusive). Can not be mixed with slot symbols
 * other chars - [MaskSlot.Char]
 * + will represent MaskSlot.Char('+')
 * Workaround to use slot symbols as chars:
 * There is special combination for it: [\slot symbol]
 * @sample: [\D] will represent MaskSlot.Char('D')
 * */

@IncubatingMaskaradeAPI
interface MaskFormatter {

    val slots: List<MaskSlot>

}