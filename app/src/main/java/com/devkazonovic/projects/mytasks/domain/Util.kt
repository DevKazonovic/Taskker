package com.devkazonovic.projects.mytasks.domain

import androidx.core.text.HtmlCompat

fun htmlToString(html: String): String {
    return HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_COMPACT).toString()
}

fun booleanToInt(boolean: Boolean): Int {
    return if (boolean) 1 else 0
}