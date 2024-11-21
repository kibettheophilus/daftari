package com.theophiluskibet.daftari.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.theophiluskibet.daftari.data.local.database.NotesDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
@ComponentScan("com.theophiluskibet.daftari")
actual class PlatformModule actual constructor()

@Single
actual class NoteDatabaseWrapper(private val context: Context){
    @Single
    actual fun createDatabase(): RoomDatabase.Builder<NotesDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath("daftari.db")

        return Room.databaseBuilder(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}