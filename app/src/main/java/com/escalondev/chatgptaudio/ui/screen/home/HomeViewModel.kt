package com.escalondev.chatgptaudio.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.escalondev.domain.interactor.home.CreateTranscriptionUseCase
import com.escalondev.domain.util.onFailure
import com.escalondev.domain.util.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createTranscriptionUseCase: CreateTranscriptionUseCase
) : ViewModel() {

    // UIState
    var uiState by mutableStateOf(UIState())
        private set

    private fun createTranscription(file: File) = viewModelScope.launch(Dispatchers.IO) {
        uiState = uiState.copy(isLoading = true)
        createTranscriptionUseCase.invoke(
            file = file,
            model = TRANSCRIPTION_MODEL
        )?.onSuccess {
            uiState = uiState.copy(message = it.text.orEmpty())
            uiState = uiState.copy(isLoading = false)
        }?.onFailure {
            uiState = uiState.copy(message = it.message.orEmpty())
            uiState = uiState.copy(isLoading = false)
        }
    }

    data class UIState(
        var message: String = "",
        var isLoading: Boolean = false
    )

    fun onUIEvent(uiEvent: UIEvent) {
        when (uiEvent) {
            is UIEvent.OnButtonClick -> {
                createTranscription(uiEvent.file)
            }
        }
    }

    sealed class UIEvent {
        data class OnButtonClick(val file: File) : UIEvent()
    }

    companion object {
        const val TRANSCRIPTION_MODEL = "whisper-1"
    }
}
