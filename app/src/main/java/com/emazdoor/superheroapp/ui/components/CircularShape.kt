package com.emazdoor.superheroapp.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * A circular background that can be used as a background for action buttons for images or
 * just a circular background. All the parameters are optional.
 * Callee can use onClick to add action to the button.
 *
 * @param onClick the lambda to invoke when the button is clicked.
 * @param modifier any modifiers to apply to the button.
 * @param enabled whether the button is enabled
 * @param interactionSource the interaction source passed to the clickable Surface.
 * @param content the content to show inside the circular button, typically an Icon or Image.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CircularBackground(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    elevation: Dp = NoElevation,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    color: Color = MaterialTheme.colorScheme.surface,
    contentColor: Color = contentColorFor(color),
    content: @Composable () -> Unit = {}
) = Surface(
    modifier = modifier,
    onClick = onClick,
    shape = CircleShape,
    color = color,
    shadowElevation = elevation,
    enabled = enabled,
    interactionSource = interactionSource,
    contentColor = contentColor
) {
    content()
}

@Preview
@Composable
fun PreviewCircularBackground() {
    Column {
        CircularBackground(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(48.dp)
        )
        CircularBackground(
            color = MaterialTheme.colorScheme.surface.copy(alpha = 0.20f),
            modifier = Modifier.size(48.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                ProvideTextStyle(MaterialTheme.typography.labelLarge.copy(fontSize = 28.nonScaledSp)) {
                    Text(text = "\uD83D\uDE0D")
                }
            }
        }
    }
}

private val NoElevation = 0.dp
private val Int.nonScaledSp: TextUnit
    @Composable
    get() = (this / LocalDensity.current.fontScale).sp


