package com.jobik.tappingtest.components.TestPreviewCard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jobik.tappingtest.ui.theme.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestPreviewCard(modifier: Modifier = Modifier.fillMaxWidth(), title: String, onClick: () -> Unit) {

    Card(
        onClick = onClick,
        modifier = modifier,
        colors = CardDefaults.cardColors(
            contentColor = CustomTheme.Colors.text,
            containerColor = CustomTheme.Colors.secondaryBackground
        )
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(vertical = 15.dp, horizontal = 20.dp)) {
            Text(title)
        }
    }
}