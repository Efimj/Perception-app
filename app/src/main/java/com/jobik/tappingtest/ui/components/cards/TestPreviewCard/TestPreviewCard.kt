package com.jobik.tappingtest.ui.components.cards.TestPreviewCard

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jobik.tappingtest.ui.theme.CustomTheme

data class TestDescription(
    val title: String,
    val description: String,
    val completionCount: Int,
    val passingTime: Int,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestPreviewCard(
    modifier: Modifier = Modifier.fillMaxWidth(),
    testDescription: TestDescription,
    onClick: () -> Unit
) {
    Card(
        onClick = onClick,
        modifier = modifier,
        colors = CardDefaults.cardColors(
            contentColor = CustomTheme.Colors.text,
            containerColor = CustomTheme.Colors.secondaryBackground
        )
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(vertical = 15.dp, horizontal = 20.dp)) {
            Text(text = testDescription.title, fontSize = 20.sp, overflow = TextOverflow.Ellipsis, maxLines = 1)
            Spacer(modifier = Modifier.height(3.dp))
            Text(
                text = testDescription.description,
                color = CustomTheme.Colors.textSecondary,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
            Spacer(modifier = Modifier.height(3.dp))
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                if (testDescription.completionCount != 0) {
                    Text(
                        text = "Finished ${testDescription.completionCount}",
                        color = CustomTheme.Colors.textSecondary,
                        fontSize = 16.sp,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                }
                Text(
                    text = "Passing time ${testDescription.passingTime}",
                    color = CustomTheme.Colors.textSecondary,
                    fontSize = 16.sp,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1
                )
            }
        }
    }
}