package com.github.mcbeelen.infi.ec.cli

import com.github.mcbeelen.infi.ec.camera.CameraSearchService
import com.github.mcbeelen.infi.ec.camera.CsvCameraRepository
import com.github.mcbeelen.infi.ec.camera.SpeedCamera
import kotlin.system.exitProcess

class CameraSearcher {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            val cameraRepository = buildCsvCameraRepositoryForCli()
            val cameraSearchService = CameraSearchService(cameraRepository)

            val cameras : List<SpeedCamera> = when {
                args.isEmpty() -> cameraSearchService.listAll()
                args.size == 1 && args[0] == "--help"-> exitWithHelpMessage()
                args.size == 2 -> cameraByFilter(cameraSearchService, args)
                else -> exitWithErrorMessage()
            }

            printCameraInformation(cameras)
        }
    }
}

fun cameraByFilter(cameraSearchService: CameraSearchService, args: Array<String>): List<SpeedCamera> {
    if (args[0] == "--name" ) {
        return cameraSearchService.findCamerasByName(args[1])
    }
    exitWithErrorMessage()
}

fun exitWithErrorMessage(): Nothing {
    System.err.println("Unsupported combination of arguments")
    exitWithHelpMessage(1)
}

private fun exitWithHelpMessage(i: Int = 0): Nothing  {
    System.err.println(HELP_MESSAGE)
    exitProcess(i)
}

fun printCameraInformation(cameras: List<SpeedCamera>) {
    cameras.forEach {
        val number = it.cameraNumber.padEnd(8)
        val description = it.description.padEnd(70)
        val latitude = it.latitude.toString().padEnd(12)
        val longitude = it.longitude.toString().padEnd(12)
        println("$number | $description | $latitude | $longitude")
    }
}



fun buildCsvCameraRepositoryForCli(): CsvCameraRepository {
    val path = System.getProperty("user.dir") + "/data/cameras-defb.csv"
    return CsvCameraRepository(path)
}

private const val HELP_MESSAGE = """
"Supported options are: 
- ListAll : `java -jar cli.jar`
- byName  : `java -jar cli.jar --name [partialName]` 
"""