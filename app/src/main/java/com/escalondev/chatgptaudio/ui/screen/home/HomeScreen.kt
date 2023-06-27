package com.escalondev.chatgptaudio.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.escalondev.chatgptaudio.ui.component.SpeechItemComponent
import com.escalondev.chatgptaudio.ui.screen.home.HomeViewModel.UIEvent.OnTranscriptionClick
import com.escalondev.chatgptaudio.ui.screen.home.HomeViewModel.UIEvent.OnTranslationClick
import com.escalondev.chatgptaudio.ui.screen.home.HomeViewModel.UIState
import com.escalondev.chatgptaudio.ui.uielement.LoadingIndicator
import com.escalondev.chatgptaudio.ui.util.ItemType
import com.escalondev.chatgptaudio.ui.util.getExternalFile

@Composable
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    LaunchedEffect(true) {
        homeViewModel.setupSpeechItemList()
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeScreenContent(
            homeViewModel.uiState,
            onIconClick = { itemType ->
                if (itemType == ItemType.Transcription.itemType) {
                    homeViewModel.onUIEvent(
                        OnTranscriptionClick(getExternalFile("lover-boy", ".mp3"))
                    )
                } else {
                    homeViewModel.onUIEvent(
                        OnTranslationClick(getExternalFile("rima1", ".mp3"))
                    )
                }
            },
        )
    }
}

@Composable
fun HomeScreenContent(
    uiState: UIState = UIState(),
    onIconClick: (String) -> Unit = {},
) {

    LoadingIndicator(uiState.isLoading)
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(items = uiState.speechItems) {
            SpeechItemComponent(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 8.dp, end = 8.dp, top = 6.dp, bottom = 16.dp),
                speechItem = it,
                onIconClick = { onIconClick(it.idType) }
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HomeScreenPreview() {
    HomeScreenContent()
}
