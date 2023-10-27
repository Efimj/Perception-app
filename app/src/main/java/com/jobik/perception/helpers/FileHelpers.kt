package com.jobik.perception.helpers

import android.content.Context
import android.net.Uri

fun saveImageToInternalStorage(context: Context, fileUri: Uri, fileName:String) {
    val inputStream = context.contentResolver.openInputStream(fileUri)
    val outputStream = context.openFileOutput(fileName, Context.MODE_PRIVATE)
    inputStream?.use { input ->
        outputStream.use { output ->
            input.copyTo(output)
        }
    }
}