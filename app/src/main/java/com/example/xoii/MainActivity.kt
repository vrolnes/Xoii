package com.example.xoii

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.xoii.components.CenterTopAppBar
import com.example.xoii.ui.theme.XoiiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XoiiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Scaffold(topBar = { TopBar(title = "Berlin Adlershof") }) {
                        
                    }
                }
            }
        }
    }
}

@Composable
fun TopBar(title: String) {
    CenterTopAppBar(
        modifier = Modifier,
        title = {
            Text(title, maxLines = 2)
        },
        navigationIcon = {
            IconButton(onClick = {/* TODO Implement when back screens added */}) {
                Icon(Icons.Filled.ArrowBack, "backIcon")
            }
        },
    actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Share",
                tint = Color.White
            )
        }
    })
}