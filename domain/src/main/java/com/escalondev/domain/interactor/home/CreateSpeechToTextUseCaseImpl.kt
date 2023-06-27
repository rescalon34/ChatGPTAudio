package com.escalondev.domain.interactor.home

import com.escalondev.domain.model.Speech
import com.escalondev.domain.repository.HomeRepository
import com.escalondev.domain.util.Result
import java.io.File
import javax.inject.Inject

class CreateSpeechToTextUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : CreateSpeechToTextUseCase {

    override suspend fun invoke(
        file: File,
        model: String,
        isTranscription: Boolean
    ): Result<Speech>? = homeRepository.createSpeechToText(file, model, isTranscription)
}
