package com.jobik.perception.screens.Statistics

import android.app.Application
import android.net.Uri
import androidx.annotation.Keep
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.net.toUri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jobik.perception.database.daos.TestResultDao
import com.jobik.perception.helpers.saveImageToInternalStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class StatisticsScreenState(
    val userImageUri: Uri? = null,
    val countFinished: Int = 0,
    val progress: Int = 0,
    val allTestTimeSeconds: Long = 0
)

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    private val application: Application,
    private val testResultDao: TestResultDao
) : ViewModel() {
    private val _screenState = mutableStateOf(StatisticsScreenState())
    val screenState: State<StatisticsScreenState> = _screenState

    init {
        val userImage = application.applicationContext.getFileStreamPath(UserImageName)
        _screenState.value = _screenState.value.copy(userImageUri = userImage.toUri())
        viewModelScope.launch {
            testResultDao.getAll().collect { itemList ->
                _screenState.value = _screenState.value.copy(
                    countFinished = itemList.size,
                    progress = 0,
                    allTestTimeSeconds = itemList.sumOf { item -> item.testDurationSeconds.toLong() })
            }
        }
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