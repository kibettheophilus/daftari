package com.theophiluskibet.daftari.domain

import com.theophiluskibet.daftari.data.local.entity.NoteEntity

interface NotesRepository {
    suspend fun addNote()
    suspend fun getNotes(): List<NoteEntity>
    //suspend fun
}