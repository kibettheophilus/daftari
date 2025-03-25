package com.theophiluskibet.daftari.data.local.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import com.theophiluskibet.daftari.data.local.converters.ListConverter
import com.theophiluskibet.daftari.data.local.dao.NotesDao
import com.theophiluskibet.daftari.data.local.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDao(): NotesDao
}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor: RoomDatabaseConstructor<NotesDatabase>{
    override fun initialize(): NotesDatabase
}

internal val DATABASE_NAME = "daftari.db"