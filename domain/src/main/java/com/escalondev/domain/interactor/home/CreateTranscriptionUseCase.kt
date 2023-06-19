package com.escalondev.domain.interactor.home

import com.escalondev.domain.model.Transcription
import com.escalondev.domain.util.Result
import java.io.File

interface CreateTranscriptionUseCase {

    suspend operator fun invoke(
        file: File,
        model: String
    ): Result<Transcription>?
}
