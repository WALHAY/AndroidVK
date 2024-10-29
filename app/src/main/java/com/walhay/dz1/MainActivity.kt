package com.walhay.dz1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        elements.intValue = savedInstanceState?.getInt("elements") ?: 0
        inverted.value = savedInstanceState?.getBoolean("inverted") ?: false
        setContent {
            NumberTable()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("elements", elements.intValue)
        outState.putBoolean("inverted", inverted.value)
    }
}