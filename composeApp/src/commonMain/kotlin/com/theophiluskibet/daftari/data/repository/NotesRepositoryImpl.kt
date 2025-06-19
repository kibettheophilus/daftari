package com.theophiluskibet.daftari.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.theophiluskibet.daftari.data.local.dao.NotesDao
import com.theophiluskibet.daftari.data.local.entity.NoteEntity
import com.theophiluskibet.daftari.domain.NotesRepository
import org.koin.core.annotation.Provided
import org.koin.core.annotation.Single

@Single
class NotesRepositoryImpl(
    private val notesDao: NotesDao,
    @Provided private val datastore: DataStore<Preferences>
): NotesRepository {
    override suspend fun addNote() {
        TODO("Not yet implemented")
    }

    override suspend fun getNotes(): List<NoteEntity> {
        TODO("Not yet implemented")
    }

}