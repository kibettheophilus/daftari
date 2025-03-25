package com.theophiluskibet.daftari.data.repository

import com.theophiluskibet.daftari.data.local.dao.NotesDao
import com.theophiluskibet.daftari.data.local.entity.NoteEntity
import com.theophiluskibet.daftari.domain.NotesRepository
import org.koin.core.annotation.Single

@Single
class NotesRepositoryImpl(private val notesDao: NotesDao): NotesRepository {
    override suspend fun addNote() {
        TODO("Not yet implemented")
    }

    override suspend fun getNotes(): List<NoteEntity> {
        TODO("Not yet implemented")
    }

}