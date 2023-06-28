package com.escalondev.chatgptaudio.ui.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.escalondev.chatgptaudio.R
import com.escalondev.chatgptaudio.ui.util.ItemType
import com.escalondev.domain.interactor.home.CreateSpeechToTextUseCase
import com.escalondev.domain.model.SpeechItem
import com.escalondev.domain.util.onFailure
import com.escalondev.domain.util.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val createSpeechToTextUseCase: CreateSpeechToTextUseCase,
) : ViewModel() {

    // UIState
    var uiState by mutableStateOf(UIState())
        private set

    private fun createTranscription(
        file: File,
        isTranscription: Boolean
    ) = viewModelScope.launch(Dispatchers.IO) {
        uiState = uiState.copy(isLoading = true)
        createSpeechToTextUseCase.invoke(
            file = file,
            model = TRANSCRIPTION_MODEL,
            isTranscription = isTranscription
        )?.onSuccess { speech ->
            val speechItems = uiState.speechItems.toMutableList()
            if (isTranscription) {
                speechItems.find { it.idType == ItemType.Transcription.itemType }?.text =
                    speech.text.orEmpty()
            } else {
                speechItems.find { it.idType == ItemType.Translation.itemType }?.text =
                    speech.text.orEmpty()
            }

            uiState = uiState.copy(speechItems = speechItems)
            uiState = uiState.copy(isLoading = false)
        }?.onFailure {
            uiState = uiState.copy(isLoading = false)
        }
    }

    fun setupSpeechItemList() {
        uiState = uiState.copy(
            speechItems = mutableListOf(
                SpeechItem(
                    idType = ItemType.Transcription.itemType,
                    title = R.string.transcription_title,
                    subTitle = R.string.transcription_subtitle,
                    text = "",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSWGcbqlYbUuPG5Mk4ecW44O6s94HfbIJ2nBQ&usqp=CAU",
                    icon = R.drawable.ic_transcription
                ),
                SpeechItem(
                    idType = ItemType.Translation.itemType,
                    title = R.string.translation_title,
                    subTitle = R.string.translation_subtitle,
                    text = "",
                    image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSt_ceWDcZBVK8r8lij-sOmjpoYjRT4qZ-tJM1Q7ozYySyTyX2ofGWU-fpg-UM83Ew14a8&usqp=CAU",
                    icon = R.drawable.ic_translate
                )
            )
        )
    }

    data class UIState(
        var speechItems: List<SpeechItem> = emptyList(),
        var isLoading: Boolean = false
    )

    fun onUIEvent(uiEvent: UIEvent) {
        when (uiEvent) {
            is UIEvent.OnTranscriptionClick -> {
                createTranscription(uiEvent.file, isTranscription = true)
            }
            is UIEvent.OnTranslationClick -> {
                createTranscription(uiEvent.file, isTranscription = false)
            }
        }
    }

    sealed class UIEvent {
        data class OnTranscriptionClick(val file: File) : UIEvent()
        data class OnTranslationClick(val file: File) : UIEvent()
    }

    companion object {
        const val TRANSCRIPTION_MODEL = "whisper-1"
    }
}
