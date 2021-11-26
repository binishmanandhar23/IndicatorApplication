package io.github.binishmanandhar23.indicatorlibrary.model

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import io.github.binishmanandhar23.indicatorlibrary.R

data class IndicatorModifications(var drawableId: Int = R.drawable.ic_circle, var tint: Color = Color.Black,var maxScale: Float = 1.5f, var rowModifier: Modifier = Modifier, var modifier: Modifier = Modifier)
