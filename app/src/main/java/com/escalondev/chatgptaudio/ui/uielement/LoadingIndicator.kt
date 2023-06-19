package com.escalondev.chatgptaudio.ui.uielement

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun LoadingIndicator(
    isLoading: Boolean = true
) {
    if (isLoading) {
        Surface(modifier = Modifier.fillMaxSize(), color = Color.Transparent) {
            CircularProgressIndicator(
                modifier = Modifier.wrapContentSize(Alignment.Center)
            )
        }
    }
}