package com.theophiluskibet.daftari.di

import androidx.room.RoomDatabase
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import com.theophiluskibet.daftari.data.local.dao.NotesDao
import com.theophiluskibet.daftari.data.local.database.NotesDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.ksp.generated.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(AppModule().module)
    }


@Module
@ComponentScan("com.theophiluskibet.daftari.data")
class DataModule {
    @Single
    fun provideDao(database: NotesDatabase): NotesDao = database.notesDao()

    @Single
    fun getNotesDb(builder: RoomDatabase.Builder<NotesDatabase>): NotesDatabase {
        return builder
            .fallbackToDestructiveMigration(true)
            .setDriver(BundledSQLiteDriver())
            .setQueryCoroutineContext(Dispatchers.IO)
            .build()
    }
}

@Module(includes = [DataModule::class, PlatformModule::class])
class AppModule

@Module
expect class PlatformModule