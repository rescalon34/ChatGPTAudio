package com.escalondev.data.repository

import com.escalondev.chatgptaudio.data.BuildConfig
import com.escalondev.data.networking.NetworkApi
import com.escalondev.domain.model.Transcription
import com.escalondev.domain.repository.HomeRepository
import com.escalondev.domain.util.Result
import java.io.File
import javax.inject.Inject
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody

class HomeRepositoryImpl @Inject constructor(
    private val networkApi: NetworkApi
) : HomeRepository {

    override suspend fun createTranscription(file: File, model: String): Result<Transcription>? {
        val filePart = MultipartBody.Part.createFormData(
            name = "file",
            filename = file.name,
            body = file.asRequestBody("audio/*".toMediaTypeOrNull())
        )

        val modelPart: RequestBody = RequestBody.create(
            MultipartBody.FORM, model
        )

        return try {
            val response = networkApi.createTranscription(
                authorization = BuildConfig.API_KEY,
                file = filePart,
                model = modelPart
            )
            if (response.isSuccessful) {
                response.body()?.let { Result.Success(it.mapToDomainModel()) }
            } else {
                Result.Error(Exception(response.errorBody()?.string()))
            }
        } catch (e: Throwable) {
            Result.Error(Exception(e.message))
        }
    }
}
