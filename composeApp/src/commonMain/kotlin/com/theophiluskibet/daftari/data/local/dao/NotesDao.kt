package com.theophiluskibet.daftari.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.theophiluskibet.daftari.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveNote(note: NoteEntity)

    @Query("SELECT * FROM notes_table")
    fun getAllNotes(): Flow<List<NoteEntity>>
}