package com.theophiluskibet.daftari.data.local.converters

import androidx.room.TypeConverter

class ListConverter {
    @TypeConverter
    fun fromString(value: String): List<String> {
        return value.split(",")
    }

    @TypeConverter
    fun toString(value: List<String>): String {
        return value.joinToString(",")
    }
}