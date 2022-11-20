package com.example.devnote.feature_note.domain.use_cases

import com.example.devnote.feature_note.domain.model.Note
import com.example.devnote.feature_note.domain.repository.NoteRepository
import com.example.devnote.feature_note.domain.util.NoteOrder
import com.example.devnote.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    // Here the repo is an interface so that we can change it in the future if we want to
    private val repository:NoteRepository
) {
    //This is where we type our business logic for getting all the notes
    // Generally in a use only one public function is defined which tells the usecase essentially.

    operator fun invoke(
        noteOrder: NoteOrder=NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {
        return repository.getNotes().map { notes->
            when(noteOrder.order){
                is OrderType.Ascending -> {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date ->  notes.sortedBy { it.timestamp }
                        is NoteOrder.Color ->   notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date ->  notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color ->   notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}