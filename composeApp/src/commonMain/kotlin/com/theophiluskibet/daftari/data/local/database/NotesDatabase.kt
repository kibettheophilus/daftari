package com.theophiluskibet.daftari.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.theophiluskibet.daftari.data.local.converters.ListConverter
import com.theophiluskibet.daftari.data.local.dao.NotesDao
import com.theophiluskibet.daftari.data.local.entity.NoteEntity

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
@TypeConverters(ListConverter::class)
abstract class NotesDatabase : RoomDatabase(), DB {
    abstract fun notesDao(): NotesDao

    override fun clearAllTables() {
        super.clearAllTables()
    }
}

/**
 * Hack copied from
 * https://github.com/joreilly/FantasyPremierLeague
 */
interface DB {
    fun clearAllTables() {}
}