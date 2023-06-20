package com.escalondev.chatgptaudio.ui.util

sealed class ItemType(val itemType: String) {
    object Transcription : ItemType("transcription")
    object Translation : ItemType("translation")
}
