package com.emazdoor.superheroapp.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.emazdoor.superheroapp.mock.MockData
import com.emazdoor.superheroapp.model.Superhero

@Composable
fun SuperHeroItemView(superhero: Superhero) {
    Divider(modifier = Modifier.padding(start = 10.dp), color = Color.LightGray)
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircularBackground(
            modifier = Modifier
                .size(48.dp)
                .padding(4.dp)
        )
        {
            ImageArt(url = superhero.images.md, fallback = fallbackAlbumArtDrawable())
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