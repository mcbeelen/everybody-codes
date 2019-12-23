package com.github.mcbeelen.infi.ec.camera

import org.springframework.boot.actuate.health.Status.UP
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CameraConfiguration {

    private val pathInProduction = System.getProperty("user.dir") + "/data/cameras-defb.csv"
    private val pathInTests = System.getProperty("user.dir") + "/../../data/cameras-defb.csv"

    @Bean
    fun cameraRepository() : CameraRepository {
        val productionRepository = CsvCameraRepository(pathInProduction)
        if (productionRepository.health().status == UP) {
            return productionRepository
        }
        val testRepository = CsvCameraRepository(pathInTests)
        if (testRepository.health().status == UP) {
            return testRepository
        }
        throw IllegalStateException("Failed to find proper camera data file")
    }

}