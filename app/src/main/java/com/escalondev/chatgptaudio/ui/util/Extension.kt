package com.escalondev.chatgptaudio.ui.util

import android.content.Context
import android.os.Environment
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.escalondev.domain.util.Constants.ONE_SECOND
import java.io.File
import java.io.IOException

fun getExternalFile(fileName: String, extension: String): File {
    val path = Environment.getExternalStoragePublicDirectory(
        Environment.DIRECTORY_DOWNLOADS
    )
    val file = File(path, fileName + extension)
    try {
        // Make sure the Pictures directory exists.
        path.mkdirs()
        file.createNewFile()
    } catch (e: IOException) {
        e.printStackTrace()
    }
    return file
}

fun getAsyncImageModel(data: Any?, context: Context) : ImageRequest {
    return ImageRequest.Builder(context)
        .data(data = data)
        .crossfade(ONE_SECOND)
        .diskCachePolicy(CachePolicy.ENABLED)
        .build()
}
