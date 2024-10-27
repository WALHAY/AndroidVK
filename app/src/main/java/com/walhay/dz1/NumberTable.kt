package com.walhay.dz1

import android.content.res.Configuration
import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

var elements = 0

@Composable
fun NumberTable() {
    val configuration = LocalConfiguration.current
    var state by remember { mutableIntStateOf(elements) }
    Column {
        LazyVerticalGrid (
            columns = GridCells.Fixed(if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 4 else 3),
            modifier = Modifier.weight(1f).fillMaxSize()
        ){
            items(state) { index ->
                Box(
                    modifier = Modifier.aspectRatio(1f)
                        .padding(5.dp)
                        .background(if (index % 2 == 0) Color.Red else Color.Blue)
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
            onClick = { state++; elements++ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        {
            Text(text = "Add")
        }
    }
}