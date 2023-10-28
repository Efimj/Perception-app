package com.jobik.perception.screens.Statistics

import android.app.Application
import android.net.Uri
import android.util.Log
import androidx.annotation.Keep
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import com.jobik.perception.database.PerceptionDB
import com.jobik.perception.helpers.saveImageToInternalStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

data class StatisticsScreenState(
    val userImageUri: Uri? = null
)

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val application: Application,
//    private val perceptionBD: PerceptionDB,
//    private val testResultRepository: TestResultRepository
) : ViewModel() {

    private val _screenState = mutableStateOf(StatisticsScreenState())
    val screenState: State<StatisticsScreenState> = _screenState

    init {
        val userImage = application.applicationContext.getFileStreamPath(UserImageName)
        _screenState.value = _screenState.value.copy(userImageUri = userImage.toUri())
        Log.d("dw", perceptionBD.testResultDao().findByTestId(1) .toString())
    }

    fun changeUserImage(uri: Uri) {
        saveImageToInternalStorage(context = application.applicationContext, fileUri = uri, fileName = UserImageName)
        _screenState.value = _screenState.value.copy(userImageUri = uri)
    }

    companion object {
        @Keep
        const val UserImageName = "UserProfileImage.jpg"
    }
}