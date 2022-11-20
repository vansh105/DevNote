package com.example.devnote.feature_note.presentation.notes.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DefaultRadioButton(
    text: String,
    Selected: Boolean,
    onSelected: ()-> Unit,
    modifier: Modifier= Modifier
){
    Row(
        modifier=modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
      RadioButton(selected = Selected,
          onClick = onSelected,
          colors = RadioButtonDefaults.colors(
              selectedColor = MaterialTheme.colors.primary,
              unselectedColor = MaterialTheme.colors.background
          )
      )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.body1)
    }
}