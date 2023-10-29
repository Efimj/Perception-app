package com.jobik.perception.screens.TestPreview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextLayoutResult
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun TestPreview(navController: NavController, viewModel: TestPreviewViewModel = hiltViewModel()) {
    var descriptionLineCount by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = viewModel.screenState.value.testId.toString(),
            onTextLayout = { textLayoutResult: TextLayoutResult ->
                descriptionLineCount = textLayoutResult.lineCount
            })
    }
}