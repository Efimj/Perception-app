package com.jobik.perception.helpers

import android.content.Context

fun formatSecondsToString(seconds: Long, context: Context): String {
    runCatching {
        val days = seconds / (3600 * 24)
        val hours = seconds / 3600
        val minutes = (seconds % 3600) / 60
        val remainingSeconds = seconds % 60

        return when {
            days > 0 -> "${days}d"
            hours > 0 -> "${hours}h"
            minutes > 0 -> "${minutes}m"
            else -> "${remainingSeconds}s"
        }
    }
    return ""
}

fun formatNumberToString(number: Long, context: Context): String {
    runCatching {
        return when {
            number >= 1_000_000 -> "${number / 1_000_000}M"
            number >= 1_000 -> "${number / 1_000}K"
            else -> number.toString()
        }
    }
    return ""
}