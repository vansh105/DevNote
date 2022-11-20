package com.example.devnote.feature_note.domain.util


// This class tells us that whether we order by date, color etc.
sealed class NoteOrder(val order: OrderType) {

    class Title(order: OrderType) : NoteOrder(order)
    class Date(order: OrderType) : NoteOrder(order)
    class Color(order: OrderType) : NoteOrder(order)

    fun copy(order: OrderType):NoteOrder {
        return when(this){
            is Title -> Title(order)
            is Date -> Date(order)
            is Color -> Color(order)
        }
    }
}