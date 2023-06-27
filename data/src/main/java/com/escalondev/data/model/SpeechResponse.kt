package com.escalondev.data.model

import com.escalondev.data.mapper.DomainMapper
import com.escalondev.domain.model.Speech
import com.google.gson.annotations.SerializedName

data class SpeechResponse(
    @SerializedName("text")
    val text: String?
) : DomainMapper<Speech> {

    override fun mapToDomainModel() = Speech(text = text)
}
