package com.escalondev.domain.repository

import com.escalondev.domain.model.Transcription
import com.escalondev.domain.util.Result
import java.io.File

interface HomeRepository {

    suspend fun createTranscription(
        file: File,
        model: String
    ): Result<Transcription>?
}
