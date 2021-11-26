package io.github.binishmanandhar23.indicatorlibrary

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import io.github.binishmanandhar23.indicatorlibrary.model.IndicatorModifications
import io.github.binishmanandhar23.indicatorlibrary.utils.IndicatorUtils.isScrolledToTheEnd

class IndicatorLibrary {

    @Composable
    fun initialize(listState: LazyListState, listSize: Int, numberOfIndicators: Int, indicatorModifications: IndicatorModifications = IndicatorModifications()) {
        val actualNumberOfIndicators = if(numberOfIndicators > listSize / 2) listSize / 2 else numberOfIndicators
        Indicators(listState, listSize, actualNumberOfIndicators, indicatorModifications)
    }


    @Composable
    private fun Indicators(listState: LazyListState, listSize: Int, numberOfIndicators: Int, indicatorModifications: IndicatorModifications) {
        val firstItemIndex = listState.firstVisibleItemIndex + 1
        val firstPart: Float = listSize / numberOfIndicators.toFloat()

        val compareList = ArrayList<Float>()
        val isInList = ArrayList<Boolean>()
        for (i in 0 until numberOfIndicators) {
            if (i == 0)
                compareList.add(firstPart).also {
                    isInList.add(firstItemIndex <= firstPart)
                }
            else
                compareList.add(compareList[i - 1] + firstPart).also {
                    isInList.add(firstItemIndex > compareList[i - 1] && firstItemIndex <= compareList[i])
                }
        }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = indicatorModifications.rowModifier
        ) {
            for (i in 0 until numberOfIndicators) {
                if (listState.isScrolledToTheEnd())
                    Icon(
                        painterResource(id = indicatorModifications.drawableId),
                        "Indicator ${i + 1}",
                        tint = indicatorModifications.tint,
                        modifier = indicatorModifications.modifier.scale(if (i == (numberOfIndicators - 1)) indicatorModifications.maxScale else 1f)
                    )
                else
                    Icon(
                        painterResource(id = indicatorModifications.drawableId),
                        "Indicator ${i + 1}",
                        tint = indicatorModifications.tint,
                        modifier = indicatorModifications.modifier.scale(if (isInList[i]) indicatorModifications.maxScale else 1f)
                    )
            }
        }
    }
}