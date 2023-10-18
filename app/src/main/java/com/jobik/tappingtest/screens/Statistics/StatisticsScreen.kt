package com.jobik.tappingtest.screens.Statistics

import android.content.Context
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.jobik.tappingtest.ui.components.bars.NavigationBottomBar.BottomAppBarHeight
import com.jobik.tappingtest.ui.components.buttons.Button.CustomButton
import com.jobik.tappingtest.ui.theme.CustomTheme
import java.io.File


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatisticsScreen(navController: NavController) {
    val openDialog = remember { mutableStateOf(false) }
    val context = LocalContext.current
    val file = remember { mutableStateOf<File?>(context.getFileStreamPath("image.jpg")) }
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) {
            it?.let {
                saveImageToInternalStorage(context, it)
                file.value = null
            }
        }
    LaunchedEffect(file.value) {
        file.value = context.getFileStreamPath("image.jpg")
    }

    Column(
        modifier = Modifier.fillMaxSize().background(CustomTheme.Colors.mainBackground).padding(
            PaddingValues(
                start = 10.dp,
                end = 10.dp,
                top = 20.dp,
                bottom = (BottomAppBarHeight + 40).dp
            )
        ),
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            AsyncImage(
                model = file.value,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().height(180.dp),
                contentScale = ContentScale.FillHeight
            )
            Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                CustomButton(
                    icon = Icons.Default.Edit,
                    modifier = Modifier.width(50.dp).height(50.dp),
                    contentPadding = PaddingValues(0.dp),
                    shape = CustomTheme.Shapes.medium,
                    border = BorderStroke(1.dp, CustomTheme.Colors.stroke),
                    contentColor = CustomTheme.Colors.textSecondary,
                    onClick = { openDialog.value = !openDialog.value; galleryLauncher.launch("image/*") }
                )
//                Card(
//                    modifier = Modifier.width(50.dp),
//                    colors = CardDefaults.cardColors(containerColor = CustomTheme.Colors.secondaryBackground),
//                    shape = CustomTheme.Shapes.large,
//                    border = BorderStroke(width = 1.dp, CustomTheme.Colors.stroke),
//                    onClick = { openDialog.value = !openDialog.value; galleryLauncher.launch("image/*") }
//                ) {
//
//                }
            }
        }
//        Card(
//            modifier = Modifier.fillMaxWidth(.7f).height(180.dp),
//            colors = CardDefaults.cardColors(containerColor = CustomTheme.Colors.secondaryBackground),
//            shape = CustomTheme.Shapes.large,
//            border = BorderStroke(width = 1.dp, CustomTheme.Colors.stroke),
//            onClick = { openDialog.value = !openDialog.value; galleryLauncher.launch("image/*") }
//        ) {
//            AsyncImage(
//                model = file.value,
//                contentDescription = null,
//                modifier = Modifier.fillMaxWidth(),
//                contentScale = ContentScale.Crop
//            )
//        }
    }
}

fun saveImageToInternalStorage(context: Context, uri: Uri) {
    val inputStream = context.contentResolver.openInputStream(uri)
    val outputStream = context.openFileOutput("image.jpg", Context.MODE_PRIVATE)
    inputStream?.use { input ->
        outputStream.use { output ->
            input.copyTo(output)
        }
    }
}