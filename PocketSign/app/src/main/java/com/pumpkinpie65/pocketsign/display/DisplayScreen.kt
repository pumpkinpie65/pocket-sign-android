package com.pumpkinpie65.pocketsign.display

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import com.pumpkinpie65.pocketsign.R

@Composable
fun DisplayScreen(
    text: String,
    onDismiss: () -> Unit,
) {
    val dismissLabel = stringResource(R.string.display_dismiss_label)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .semantics { contentDescription = dismissLabel }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onDismiss,
            )
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        AutoSizeText(
            text = text,
            color = Color.White,
            modifier = Modifier.fillMaxSize()
        )
    }
}
