package com.emazdoor.superheroapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * A Text view that can show text view.
 * TODO: extend functionality to work with custom font family
 *
 * @param modifier any modifiers to apply to the button.
 * @param text content to show
 * @param color content color
 * @param fontSize content font size
 */
@Composable
fun TextView(modifier: Modifier = Modifier,
             text: String,
             color: Color = Color.Black,
             fontSize : TextUnit = 12.sp) {
    Text(text = text, modifier = modifier, color = color, fontSize = fontSize)
}

@Preview
@Composable
fun PreviewText(){
    Column() {
        TextView(text = "Default Text")
        TextView(text = "Light Gray with 8 font size", color = Color.LightGray, fontSize = 8.sp)
    }
}