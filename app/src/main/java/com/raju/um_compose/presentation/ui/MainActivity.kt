package com.raju.um_compose.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.raju.um_compose.common.Navigation
import com.raju.um_compose.presentation.ui.theme.UMComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UMComposeTheme {
                Navigation()
            }
        }
    }
}