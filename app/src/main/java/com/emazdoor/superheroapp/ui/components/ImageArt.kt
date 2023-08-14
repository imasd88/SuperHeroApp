package com.emazdoor.superheroapp.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.emazdoor.superheroapp.R

/**
 * [AsyncImage] for displaying Image art. Handles placeholder, fallback, scaling
 *  and loading.
 *
 * @param url the URL of the image to display. Will start to load, can be null in which case the fallback will be used.
 * @param fallback a drawable resource ID for a fallback artwork image to use whilst the actual
 *  image is being loaded or in case the actual image fails to load.
 * @param modifier any modifiers to apply to the image.
 */
@Composable
fun ImageArt(
    url: String?,
    @DrawableRes fallback: Int,
    modifier: Modifier = Modifier,
) = AsyncImage(
    modifier = modifier,
    model = ImageRequest.Builder(LocalContext.current)
        .data(url)
        .crossfade(true)
        .placeholder(fallback)
        .fallback(fallback)
        .error(fallback)
        .build(),
    contentDescription = null,
    contentScale = ContentScale.Crop,
)

/**
 * Returns a drawable resource ID for fallback image.
 */
@DrawableRes
fun fallbackAlbumArtDrawable() = R.drawable.placeholder_image