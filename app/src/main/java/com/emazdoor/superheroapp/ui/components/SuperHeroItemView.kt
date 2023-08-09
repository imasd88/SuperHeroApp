package com.emazdoor.superheroapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emazdoor.superheroapp.R

@Composable
fun ItemView() {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically) {
        CircularBackground(modifier = Modifier.size(48.dp).padding(4.dp))
        {
            Image(
                painter = painterResource(id = R.drawable.placeholder_image),
                contentDescription = "circular image"
            )
        }
        Column( modifier = Modifier.weight(1f).padding(start = 4.dp)) {
            TextView(text = "Batman", color = Color.Red)
            TextView(text = "Harry Potter")
        }
    }
}

@Preview
@Composable
fun PreviewItemView (){
    ItemView()
}