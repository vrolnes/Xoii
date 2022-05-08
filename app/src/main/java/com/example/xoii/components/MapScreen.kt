package com.example.xoii.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.xoii.viewModels.MapsViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("MissingPermission")
@Composable
fun MapScreen() {
    val viewModel: MapsViewModel = viewModel()
    val context = LocalContext.current

    val fusedLocationProviderClient = FusedLocationProviderClient(context)
    var lat = 0.0
    var longt = 0.0

    val cameraPositionState = rememberCameraPositionState() {
        position = CameraPosition.fromLatLngZoom(LatLng(lat, longt), 15f)
    }

    fusedLocationProviderClient.lastLocation.addOnSuccessListener {
        lat = it.latitude
        longt = it.longitude
    }

    GoogleMap(
        modifier = Modifier.fillMaxWidth(),
        properties = viewModel.state.properties,
        uiSettings = MapUiSettings(zoomControlsEnabled = false, myLocationButtonEnabled = true),
        cameraPositionState = cameraPositionState,
        onMapLoaded = {
            cameraPositionState.move(CameraUpdateFactory.newLatLng(LatLng(lat, longt)))
        }
    )
}

