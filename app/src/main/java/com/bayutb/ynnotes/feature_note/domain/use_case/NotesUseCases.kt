package com.bayutb.ynnotes.feature_note.domain.use_case

data class NotesUseCases(
    val getNotesUseCase: GetNotesUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val insertNoteUseCase: InsertNoteUseCase,
    val getNoteUseCase: GetNoteUseCase
)