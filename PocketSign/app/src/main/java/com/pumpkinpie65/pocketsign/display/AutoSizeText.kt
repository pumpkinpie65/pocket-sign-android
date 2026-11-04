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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.Hyphens
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

/**
 * Shrinks the font until the text fits its bounds. Starts big and steps down.
 * The text is hidden until it fits, so you don't see the shrinking happen.
 *
 * Wrapping at spaces is allowed. A line that ends inside a word counts as not
 * fitting, because soft wrap splits an oversized word instead of overflowing.
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
        style = TextStyle(
            lineBreak = LineBreak.Simple,
            hyphens = Hyphens.None,
        ),
        modifier = modifier
            .drawWithContent { if (readyToDraw) drawContent() },
        onTextLayout = { result ->
            val lineEnds = (0 until result.lineCount - 1).map { line ->
                result.getLineEnd(line, visibleEnd = true)
            }
            val overflows = result.didOverflowHeight ||
                result.didOverflowWidth ||
                wrapsInsideWord(text, lineEnds)
            if (overflows && fontSize.value > minFontSize.value) {
                fontSize = (fontSize.value * 0.9f).sp
            } else {
                readyToDraw = true
            }
        }
    )
}

/**
 * True when a wrapped line ends between two non-whitespace characters.
 * [exclusiveLineEnds] are the exclusive end offsets of every line but the last.
 */
internal fun wrapsInsideWord(text: String, exclusiveLineEnds: Iterable<Int>): Boolean {
    for (end in exclusiveLineEnds) {
        if (end <= 0 || end >= text.length) continue
        val before = text[end - 1]
        val after = text[end]
        if (!before.isWhitespace() && !after.isWhitespace()) return true
    }
    return false
}
