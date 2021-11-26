package io.github.binishmanandhar23.indicatorapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.binishmanandhar23.indicatorapplication.ui.theme.IndicatorApplicationTheme
import io.github.binishmanandhar23.indicatorlibrary.IndicatorLibrary

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val colorList = listOf(
                Color.Black,
                Color.Blue,
                Color.Cyan,
                Color.DarkGray,
                Color.Green,
                Color.Gray,
                Color.Magenta,
                Color.Yellow,
                Color.Black,
                Color.Blue,
                Color.Cyan,
                Color.DarkGray,
                Color.Green,
                Color.Gray,
                Color.Magenta,
                Color.Yellow,
                Color.Black,
                Color.Blue,
                Color.Cyan,
                Color.DarkGray,
                Color.Green,
                Color.Gray,
                Color.Magenta,
                Color.Yellow,
                Color.Black, Color.Blue, Color.Cyan, Color.DarkGray, Color.Green, Color.Gray, Color.Magenta, Color.Yellow,
            )
            val listState = rememberLazyListState()
            IndicatorApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        BoardColorSwitcher(listState = listState, colorList = colorList)
                        Spacer(modifier = Modifier.padding(20.dp))
                        IndicatorLibrary().initialize(
                            listState = listState,
                            listSize = colorList.size,
                            numberOfIndicators = 5
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun BoardColorSwitcher(listState: LazyListState, colorList: List<Color>) {
    val hapticFeedback = LocalHapticFeedback.current
    var selectedIndex by remember { mutableStateOf(1) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Text(
            "Change color",
            modifier = Modifier.padding(6.dp)
        )

        LazyRow(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(colorList) { item ->
                Box(
                    modifier = Modifier
                        .padding(12.dp)
                        .height(100.dp)
                        .width(100.dp)
                        .background(
                            color = item,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .clickable {
                            hapticFeedback.performHapticFeedback(HapticFeedbackType.LongPress)
                        }
                ) {
                    /* Image(
                         painter = painterResource(id = R.drawable.dude_dnarollercoaster),
                         contentDescription = "appLogo",
                         modifier = Modifier
                             .padding(4.dp)
                             .fillMaxWidth()
                             .fillMaxHeight()
                             .background(color = Color(R.color.colorIce))
                     )*/
                }
            }
        }
    }
}