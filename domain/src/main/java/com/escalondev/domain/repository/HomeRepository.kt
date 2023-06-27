package com.escalondev.domain.repository

import com.escalondev.domain.model.Speech
import com.escalondev.domain.util.Result
import java.io.File

interface HomeRepository {

    suspend fun createSpeechToText(
        file: File,
        model: String,
        isTranscription: Boolean
    ): Result<Speech>?
}
