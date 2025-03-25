package com.theophiluskibet.daftari.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.theophiluskibet.daftari.data.local.database.DATABASE_NAME
import com.theophiluskibet.daftari.data.local.database.NotesDatabase
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import java.io.File

@Module
@ComponentScan("com.theophiluskibet.daftari")
actual class PlatformModule

@Single
fun createDatabase(): RoomDatabase.Builder<NotesDatabase>{
    val dbFile = File(System.getProperty("java.io.tmpdir"), DATABASE_NAME)
    return Room.databaseBuilder(
        name = dbFile.absolutePath
    )
}