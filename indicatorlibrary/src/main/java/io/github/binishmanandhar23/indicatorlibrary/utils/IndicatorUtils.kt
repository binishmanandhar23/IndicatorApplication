package io.github.binishmanandhar23.indicatorlibrary.utils

import androidx.compose.foundation.lazy.LazyListState

object IndicatorUtils {
    fun LazyListState.isScrolledToTheEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1
}