package com.jobik.tappingtest.ui.components.buttons.Button

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jobik.tappingtest.ui.theme.CustomTheme
import com.jobik.tappingtest.utils.ThemeUtil.ThemeUtil

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon: ImageVector? = null,
    onClick: () -> Unit,
    isActive: Boolean = false,
    isEnabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    shape: Shape = CustomTheme.Shapes.small,
    border: BorderStroke? = null,
    contentColor: Color = CustomTheme.Colors.text,
    contentDescription: String = "button icon"
) {
    val backgroundColor = if (isActive) CustomTheme.Colors.active else CustomTheme.Colors.secondaryBackground
    val foregroundColor = if (isActive) CustomTheme.Colors.textOnActive else contentColor

    val containerColor = remember { Animatable(backgroundColor) }
    val contentColor = remember { Animatable(foregroundColor) }

    LaunchedEffect(isActive) {
        containerColor.animateTo(backgroundColor, animationSpec = tween(200))
    }

    LaunchedEffect(isActive) {
        contentColor.animateTo(foregroundColor, animationSpec = tween(200))
    }

    LaunchedEffect(ThemeUtil.isDarkMode.value) {
        containerColor.snapTo(backgroundColor)
    }

    LaunchedEffect(ThemeUtil.isDarkMode.value) {
        contentColor.snapTo(foregroundColor)
    }

    Button(
        enabled = isEnabled,
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor.value,
            contentColor = contentColor.value
        ),
        shape = shape,
        border = border,
        contentPadding = contentPadding,
    ) {
        Row(
            modifier = modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (icon != null)
                Icon(
                    imageVector = icon,
                    modifier = Modifier.size(25.dp),
                    contentDescription = contentDescription,
                )
            if (text != null && icon != null)
                Spacer(modifier = Modifier.width(6.dp))
            if (text != null)
                Text(
                    text = text,
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Normal,
                    fontSize = 16.sp
                )
        }
    }
}