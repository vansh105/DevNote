package com.example.devnote.feature_note.domain.use_cases

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val deleteNote: DeleteNoteUseCase,
    val AddNote: AddNote,
    val getNote: GetNote
)
