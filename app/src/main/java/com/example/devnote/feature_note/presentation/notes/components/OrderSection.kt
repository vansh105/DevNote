package com.example.devnote.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.devnote.feature_note.domain.util.NoteOrder
import com.example.devnote.feature_note.domain.util.OrderType

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    onOrderChange: (NoteOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        DefaultRadioButton(text = "Title",
            Selected = noteOrder is NoteOrder.Title,
            onSelected = { onOrderChange(NoteOrder.Title(noteOrder.order)) }
        )
        Spacer(modifier = Modifier.width(8.dp))

        DefaultRadioButton(text = "Date",
            Selected = noteOrder is NoteOrder.Date,
            onSelected = { onOrderChange(NoteOrder.Date(noteOrder.order)) }
        )
        Spacer(modifier = Modifier.width(8.dp))

        DefaultRadioButton(text = "Color",
            Selected = noteOrder is NoteOrder.Color,
            onSelected = { onOrderChange(NoteOrder.Color(noteOrder.order)) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row (modifier=modifier.fillMaxWidth())
        {
            DefaultRadioButton(text = "Ascending",
                Selected = noteOrder.order is OrderType.Ascending,
                onSelected = { onOrderChange(noteOrder.copy(OrderType.Ascending)) }
            )
            Spacer(modifier = Modifier.width(8.dp))

            DefaultRadioButton(text = "Descending",
                Selected = noteOrder.order is OrderType.Descending,
                onSelected = { onOrderChange(noteOrder.copy(OrderType.Descending)) }
            )
        }
    }
}