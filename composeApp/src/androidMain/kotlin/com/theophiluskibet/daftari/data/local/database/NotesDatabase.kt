package com.theophiluskibet.daftari.data.local.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import org.koin.core.annotation.Single

@Single
fun createDatabase(context: Context): RoomDatabase.Builder<NotesDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath("daftari.db")

    return Room.databaseBuilder(
        context = appContext,
        name = dbFile.absolutePath
    )
}