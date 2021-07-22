package com.devkazonovic.projects.mytasks.data.local.db.converter

import androidx.room.TypeConverter
import com.devkazonovic.projects.mytasks.help.util.offsetDateTimeToString
import com.devkazonovic.projects.mytasks.help.util.stringToOffsetDateTime
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter

class MyTasksTypeConverters {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    fun toOffsetDateTime(value: String?): OffsetDateTime? = stringToOffsetDateTime(value)


    @TypeConverter
    fun fromOffsetDateTime(date: OffsetDateTime?): String? = offsetDateTimeToString(date)
}