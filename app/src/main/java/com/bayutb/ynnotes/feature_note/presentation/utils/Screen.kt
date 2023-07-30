package com.bayutb.ynnotes.feature_note.presentation.utils

sealed class Screen (val route: String) {

    object NotesScreen: Screen("notes_screen")
    object AddEditNoteScren: Screen("add_edit_note_screen")

}