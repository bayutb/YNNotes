package com.bayutb.ynnotes.di

import android.app.Application
import androidx.room.Room
import com.bayutb.ynnotes.feature_note.data.data_source.NoteDatabase
import com.bayutb.ynnotes.feature_note.data.repository.NoteRepositoryImpl
import com.bayutb.ynnotes.feature_note.domain.repository.NoteRepository
import com.bayutb.ynnotes.feature_note.domain.use_case.DeleteNoteUseCase
import com.bayutb.ynnotes.feature_note.domain.use_case.GetNoteUseCase
import com.bayutb.ynnotes.feature_note.domain.use_case.GetNotesUseCase
import com.bayutb.ynnotes.feature_note.domain.use_case.InsertNoteUseCase
import com.bayutb.ynnotes.feature_note.domain.use_case.NotesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteCaseUseCases(repository: NoteRepository): NotesUseCases {
        return NotesUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            insertNoteUseCase = InsertNoteUseCase(repository),
            getNoteUseCase = GetNoteUseCase(repository)
        )
    }
}