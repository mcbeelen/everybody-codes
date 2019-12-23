package com.github.mcbeelen.infi.ec.camera

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class CameraRepositoryTest {


    @Test
    fun itShouldReadTheDataFromTheCsv() {
        val cameraRepository = buildCsvCameraRepositoryForTests()

        val allCameras = cameraRepository.listAll()

        assertThat(allCameras.size, equalTo(88))
    }


}

fun buildCsvCameraRepositoryForTests(): CsvCameraRepository {
    val path = System.getProperty("user.dir") + "/../../data/cameras-defb.csv"
    return CsvCameraRepository(path)
}
