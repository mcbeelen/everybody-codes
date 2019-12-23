package com.github.mcbeelen.infi.ec.camera

import java.io.File
import java.nio.file.Paths

interface CameraRepository {
    fun listAll(): List<SpeedCamera>
}

class CsvCameraRepository(private val path: String) : CameraRepository {

    private val cameras: List<SpeedCamera> by lazy {
        readCamerasFromFile()
    }

    private fun readCamerasFromFile(): List<SpeedCamera> {

        val dataFile = File(Paths.get(path).toUri())
        return dataFile.readLines()
                .filter { it.startsWith("UTR-CM-") }
                .map {
                    parseToSpeedCamera(it)
                }
    }


    override fun listAll(): List<SpeedCamera> {
        return cameras
    }
}


fun parseToSpeedCamera(cameraLine: String): SpeedCamera {

    val split = cameraLine.split(';')
    try {
        val description = split[0]
        val latitude = split[1].toDouble()
        val longitude = split[2].toDouble()
        val number = description.drop(7).take(3)
        return SpeedCamera(number, description, latitude, longitude)
    } catch (e: IndexOutOfBoundsException) {
        println(e)
    }
    throw IllegalArgumentException(cameraLine)

}
