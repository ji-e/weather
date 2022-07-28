package com.jieun.weather.common

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * 날짜 포맷 정리
 * */
const val DATE_PATTERN_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss"
const val DATE_PATTERN_yyyy_MM_dd = "yyyy-MM-dd"

/**
 * SimpleDateFormat 공통
 * */
fun commonSdf(pattern: String) = SimpleDateFormat(pattern, Locale.KOREA)

/**
 * Date -> String
 * */
fun Date?.dateToStringFormat(pattern: String) = commonSdf(pattern).format(this ?: Date()) ?: ""

/**
 * String -> String
 */
fun String?.stringToStringFormat(datePattern: String, stringPattern: String): String {
    this ?: return ""
    val date = commonSdf(datePattern).parse(this)
    return date.dateToStringFormat(stringPattern)
}
