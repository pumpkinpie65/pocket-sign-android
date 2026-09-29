package com.pumpkinpie65.pocketsign.display

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Shrinks the font until the text fits its bounds. Starts big and steps down.
 * The text is hidden until it fits, so you don't see the shrinking happen.
 */
@Composable
fun AutoSizeText(
    text: String,
    color: Color,
    modifier: Modifier = Modifier,
    maxFontSize: TextUnit = 500.sp,
    minFontSize: TextUnit = 12.sp
) {
    var fontSize by remember(text) { mutableStateOf(maxFontSize) }
    var readyToDraw by remember(text) { mutableStateOf(false) }

    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        lineHeight = (fontSize.value * 1.1f).sp,
        textAlign = TextAlign.Center,
        modifier = modifier
            .drawWithContent { if (readyToDraw) drawContent() },
        onTextLayout = { result ->
            val overflows = result.didOverflowHeight || result.didOverflowWidth
            if (overflows && fontSize.value > minFontSize.value) {
                fontSize = (fontSize.value * 0.9f).sp
            } else {
                readyToDraw = true
            }
        }
    )
}
