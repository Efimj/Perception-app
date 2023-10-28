package com.jobik.perception.database.converters

import androidx.room.TypeConverter
import java.time.LocalDateTime


class LocalDateTimeConverter {
    @TypeConverter
    fun toDate(dateString: String?): LocalDateTime? {
        runCatching {
            return if (dateString == null) {
                null
            } else {
                LocalDateTime.parse(dateString)
            }
        }
        return null
    }

    @TypeConverter
    fun toString(date: LocalDateTime?): String? {
        return date?.toString()
    }
}