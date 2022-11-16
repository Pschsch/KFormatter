# Maskarade
Kotlin-powered multiplatform-support solution to format strings using masks in easy way.

## Concept

The key entity in whole project is **Mask**

```kotlin
@IncubatingMaskaradeAPI
interface Mask : Collection<Mask.Slot>, Parcelable, Serializable {

    val hint : String
    
    sealed class Slot : Parcelable, Serializable {
        object Digit : Slot()
        
        object Letter : Slot()
        
        data class Hardcoded(val symbol: Char) : Slot()
    }
}
```

Obtain mask with provided factory functions:
```kotlin
@IncubatingMaskaradeAPI
fun Mask(block : MaskBuilder.() -> Unit): Mask

@IncubatingMaskaradeAPI
fun Mask(stringRepresentation: String): Mask

@IncubatingMaskaradeAPI
fun Mask(fromSingleChar: Char): Mask

@IncubatingMaskaradeAPI
fun Mask(slot: Mask.Slot): Mask

@IncubatingMaskaradeAPI
fun Mask(slots: Iterable<Mask.Slot>): Mask
```

## Platform Compatibilities

| java.io.Serializable  | Android, JVM |
|:---------------------:|:------------:|
| android.os.Parcelable |   Android    |


## Android API Level Support

|  maskarade-core   | API level 14 |
|:-----------------:|:------------:|
| maskarade-compose | API level 21 |