package com.escalondev.domain.interactor.home

import com.escalondev.domain.model.Speech
import com.escalondev.domain.util.Result
import java.io.File

interface CreateSpeechToTextUseCase {

    suspend operator fun invoke(
        file: File,
        model: String,
        isTranscription: Boolean
    ): Result<Speech>?
}
