package com.escalondev.domain.interactor.home

import com.escalondev.domain.model.Transcription
import com.escalondev.domain.repository.HomeRepository
import com.escalondev.domain.util.Result
import java.io.File
import javax.inject.Inject

class CreateTranscriptionUseCaseImpl @Inject constructor(
    private val homeRepository: HomeRepository
) : CreateTranscriptionUseCase {

    override suspend fun invoke(file: File, model: String): Result<Transcription>? =
        homeRepository.createTranscription(file, model)
}
