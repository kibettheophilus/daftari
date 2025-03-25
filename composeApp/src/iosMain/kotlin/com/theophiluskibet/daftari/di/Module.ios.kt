package com.theophiluskibet.daftari.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.theophiluskibet.daftari.data.local.database.DATABASE_NAME
import com.theophiluskibet.daftari.data.local.database.NotesDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

@Module
@ComponentScan("com.theophiluskibet.daftari.di")
actual class PlatformModule

@Single
fun createDatabase(): RoomDatabase.Builder<NotesDatabase> {
    val dbPath = documentDirectory() + "/$DATABASE_NAME"
    return Room.databaseBuilder(
        name = dbPath
    )
}

@OptIn(ExperimentalForeignApi::class)
private fun documentDirectory(): String {
    val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
        directory = NSDocumentDirectory,
        inDomain = NSUserDomainMask,
        appropriateForURL = null,
        create = false,
        error = null,
    )
    return requireNotNull(documentDirectory?.path)
}