package com.jobik.perception.screens.TestPreview

import android.app.Application
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jobik.perception.database.daos.TestResultDao
import com.jobik.perception.navigation.ArgumentTestName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class TestPreviewScreenState(
    val testId: String? = null,
    val countFinished: Int = 0,
    val progress: Int = 0,
)

@HiltViewModel
class TestPreviewViewModel @Inject constructor(
    private val application: Application,
    private val testResultDao: TestResultDao,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _screenState = mutableStateOf(TestPreviewScreenState())
    val screenState: State<TestPreviewScreenState> = _screenState

    init {
        val currentTestId: String? = savedStateHandle[ArgumentTestName]
        currentTestId?.let { testId ->
            _screenState.value = _screenState.value.copy(
                testId = testId
            )
            viewModelScope.launch {
                testResultDao.getAll().collect { itemList ->
                    _screenState.value = _screenState.value.copy(
                        countFinished = itemList.count { it.testName == testId },
                        progress = 0,
                    )
                }
            }
        }

    }
}