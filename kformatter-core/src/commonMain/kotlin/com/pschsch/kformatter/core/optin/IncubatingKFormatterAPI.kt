package com.pschsch.kformatter.core.optin

@RequiresOptIn(message = "This API is incubating. It may be changed in future")
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.FIELD)
annotation class IncubatingKFormatterAPI
