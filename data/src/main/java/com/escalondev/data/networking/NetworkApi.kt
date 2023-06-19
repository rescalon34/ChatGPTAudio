package com.escalondev.data.networking

import com.escalondev.data.model.TranscriptionResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface NetworkApi {

    @Multipart
    @POST("audio/transcriptions")
    suspend fun createTranscription(
        @Header("Authorization") authorization: String?,
        @Part file: MultipartBody.Part,
        @Part("model") model: RequestBody
    ): Response<TranscriptionResponse>
}
