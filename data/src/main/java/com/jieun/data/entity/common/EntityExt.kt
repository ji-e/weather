package com.jieun.data.entity.common

fun String?.default() = this ?: ""
fun Int?.default() = this ?: 0
fun Int?.idDefault() = this ?: -1
fun <T> List<T>?.default() = this ?: emptyList()
fun Boolean?.default() = this ?: false
fun Float?.default() = this ?: 0f
fun Double?.default() = this ?: 0.0
fun Long?.default() = this ?: 0L
fun Long?.idDefault() = this ?: -1
