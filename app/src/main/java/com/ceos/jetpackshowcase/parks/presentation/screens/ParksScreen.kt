package com.ceos.jetpackshowcase.parks.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.toBitmap
import com.ceos.jetpackshowcase.R
import com.ceos.jetpackshowcase.parks.domain.models.Park
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState


private val Park.position: LatLng
    get() {
        return LatLng(this.lat, this.lng)
    }

@Composable
fun ParksScreen(vm: ParksScreenViewModel) {
    LaunchedEffect(key1 = true) {
        vm.getParks()
    }

    val parks = vm.parks.collectAsState()
    val montreal = LatLng(45.508888, -73.561667)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(montreal, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        val pinIcon = ResourcesCompat.getDrawable(
            LocalContext.current.resources,
            R.drawable.pin_parks,
            null
        )?.toBitmap()?.let {
            BitmapDescriptorFactory.fromBitmap(it)
        }

        parks.value.forEach { park ->
            Marker(
                state = MarkerState(position = park.position),
                title = park.name,
                snippet = park.description,
                icon = pinIcon
            )

        }
    }
}