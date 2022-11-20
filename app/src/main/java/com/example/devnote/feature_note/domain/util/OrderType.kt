package com.example.devnote.feature_note.domain.util

//This class will help us to tell whether to sort our list in ascending or descending order
sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}