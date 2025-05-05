package com.brunadev.tm.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.toDate(
    dateFormat: String = "yyyy-MM-dd",
    timeZone: TimeZone = TimeZone.getTimeZone("UTC")
): Date {
    val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
    parser.timeZone = timeZone
    return parser.parse(this)
}