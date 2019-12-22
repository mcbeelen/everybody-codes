package com.github.mcbeelen.infi.ec.camera

import java.io.File
import java.nio.file.Paths

class CameraRepository {

    private val cameras: List<SpeedCamera> by lazy {

        readCamerasFromFile()
    }

    private fun readCamerasFromFile(): List<SpeedCamera> {
        val path = System.getProperty("user.dir") + "/../../data/cameras-defb.csv"
        val file = File(Paths.get(path).toUri())
        return file.readLines().drop(1).map {
            parseToSpeedCamera(it)
        }
    }


    fun listAll(): List<SpeedCamera> {
        return cameras
    }
}


fun parseToSpeedCamera(cameraLine: String): SpeedCamera {

    val split = cameraLine.split(';')

    val description = split[0]
    val latitude = split[1].toDouble()
    val longitude = split[2].toDouble()
    val number = description.drop(7).take(3)

    return SpeedCamera(number, description, latitude, longitude)

}