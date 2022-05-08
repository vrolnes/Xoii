package com.example.xoii.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.xoii.models.MapState

class MapsViewModel : ViewModel() {
    var state by mutableStateOf(MapState())
}