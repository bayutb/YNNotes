package com.bayutb.ynnotes.feature_note.domain.use_case

import com.bayutb.ynnotes.feature_note.domain.model.InvalidNoteException
import com.bayutb.ynnotes.feature_note.domain.model.Note
import com.bayutb.ynnotes.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class InsertNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("The title can't be empty.")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("The content can't be empty.")
        }
        repository.insertNote(note)
    }
}