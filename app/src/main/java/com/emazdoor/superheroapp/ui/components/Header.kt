package com.emazdoor.superheroapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/** [Box] Header view for the Super Hero Screens
 * @param modifier any modifiers to apply to the header
 * @param content content to be wrapped inside the header
* */
@Composable
fun Header(modifier: Modifier = Modifier, content: @Composable (BoxScope) -> Unit) {
    Box(
        modifier = modifier
            .background(Color.Red),
    ) {
        content(this)
    }
}
