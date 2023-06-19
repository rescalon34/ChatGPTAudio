package com.escalondev.chatgptaudio.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.escalondev.chatgptaudio.ui.uielement.LoadingIndicator
import com.escalondev.chatgptaudio.ui.util.getExternalFile

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 24.dp, end = 24.dp)
    ) {
        LoadingIndicator(homeViewModel.uiState.isLoading)
        Text(text = homeViewModel.uiState.message, Modifier)
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                homeViewModel.onUIEvent(
                    HomeViewModel.UIEvent.OnButtonClick(
                        getExternalFile(
                            "life_goes_on",
                            ".mp3"
                        )
                    )
                )
            }
        ) {
            Text(text = "Click me!")
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
