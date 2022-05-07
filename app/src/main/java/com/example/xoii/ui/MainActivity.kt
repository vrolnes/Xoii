package com.example.xoii.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.xoii.navigation.Navigation
import com.example.xoii.viewModels.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi

class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(mainViewModel)
        }
    }
}