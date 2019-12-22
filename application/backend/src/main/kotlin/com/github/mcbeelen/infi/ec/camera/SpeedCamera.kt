package com.github.mcbeelen.infi.ec.camera


typealias Latitude = Double
typealias Longitude = Double

// Camera;Latitude;Longitude
data class SpeedCamera(val cameraNumber: String, val description: String, val latitude: Latitude, val longitude: Longitude) {
}