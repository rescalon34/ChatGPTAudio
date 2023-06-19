package com.escalondev.data.model

import com.escalondev.data.mapper.DomainMapper
import com.escalondev.domain.model.Transcription
import com.google.gson.annotations.SerializedName

data class TranscriptionResponse(
    @SerializedName("text")
    val text: String?
) : DomainMapper<Transcription> {

    override fun mapToDomainModel() = Transcription(text = text)
}
