package com.elavngeeks.hymnbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.elavngeeks.hymnbox.ui.theme.DescriptionText
import com.elavngeeks.hymnbox.ui.theme.HymnBoxTheme
import com.elavngeeks.hymnbox.ui.theme.HymnTab
import com.elavngeeks.hymnbox.ui.theme.SearchBar
import com.elavngeeks.hymnbox.ui.theme.TopSection

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HymnBoxTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Black
                ) {
                    Column {
                        TopSection()
                        DescriptionText()
                        SearchBar()
                        HymnTab()
                    }
                }
            }
        }
    }
}



