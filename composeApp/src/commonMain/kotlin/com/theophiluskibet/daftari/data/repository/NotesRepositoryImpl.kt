package com.theophiluskibet.daftari.data.repository

import com.theophiluskibet.daftari.data.local.dao.NotesDao
import com.theophiluskibet.daftari.domain.NotesRepository
import org.koin.core.annotation.Single

@Single
class NotesRepositoryImpl(private val notesDao: NotesDao): NotesRepository {

}