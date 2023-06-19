package com.escalondev.chatgptaudio.ui.util

import android.os.Environment
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