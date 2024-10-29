package com.walhay.dz1

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

var elements = mutableIntStateOf(0)
var inverted = mutableStateOf(false)

@Composable
fun NumberTable() {
    val configuration = LocalConfiguration.current
    val state = remember { elements }
    val inverted = remember { inverted }
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    val columnsCount = if (isLandscape) 4 else 3
    Column {
        LazyVerticalGrid (
            columns = GridCells.Fixed(columnsCount),
            modifier = Modifier.weight(1f).fillMaxSize()
        ){
            items(state.intValue) { index ->
                Box(
                    modifier = Modifier.aspectRatio(1f)
                        .padding(5.dp)
                        .background(if ((index % 2 == 0) == inverted.value) Color.Red else Color.Blue)
                        .clickable {
                            inverted.value = !inverted.value
                        }
                )
                {
                    Text(text = "$index",
                        color = Color.White,
                        fontSize = 24.sp,
                        modifier = Modifier.align(Alignment.Center))
                }
            }
        }
        Button (
            onClick = {
                state.intValue++
                      },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        {
            Text(text = "Add")
        }
    }
}