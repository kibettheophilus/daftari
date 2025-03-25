package com.theophiluskibet.daftari.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.theophiluskibet.daftari.data.local.database.DATABASE_NAME
import com.theophiluskibet.daftari.data.local.database.NotesDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.theophiluskibet.daftari")
actual class PlatformModule

@Single
fun createDatabase(context: Context): RoomDatabase.Builder<NotesDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(DATABASE_NAME)

    return Room.databaseBuilder(
        context = appContext,
        name = dbFile.absolutePath
    )
}