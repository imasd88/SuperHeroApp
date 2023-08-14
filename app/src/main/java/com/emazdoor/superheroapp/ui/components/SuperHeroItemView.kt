package com.emazdoor.superheroapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emazdoor.superheroapp.mock.MockData
import com.emazdoor.superheroapp.model.Superhero

@Composable
fun SuperHeroItemView(superhero: Superhero, onClick: (Int) -> Unit = { }) {
    Divider(modifier = Modifier.padding(start = 10.dp), color = Color.LightGray)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onClick(superhero.id)
            }
            .semantics {
                contentDescription = "Superhero ${superhero.name}"
            },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CircularBackground(
            modifier = Modifier
                .size(48.dp)
                .padding(4.dp)
        )
        {
            ImageArt(url = superhero.images.md, fallback = fallbackAlbumArtDrawable(), contentDescription = "Superhero ${superhero.name} Image")
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 4.dp)
        ) {
            superhero.apply {
                TextView(text = name, color = Color.Red)
                TextView(text = biography.fullName)
            }
        }
    }
}

@Preview
@Composable
fun PreviewItemView() {
    SuperHeroItemView(MockData.getMockData()[0])
}