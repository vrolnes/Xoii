package com.example.xoii.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.xoii.viewModels.MapsViewModel
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings

@Composable
fun MapScreen() {
    val viewModel: MapsViewModel = viewModel()

      GoogleMap(
        modifier = Modifier.fillMaxWidth(),
        properties = viewModel.state.properties,
        uiSettings = MapUiSettings(zoomControlsEnabled = false),
      )
}

