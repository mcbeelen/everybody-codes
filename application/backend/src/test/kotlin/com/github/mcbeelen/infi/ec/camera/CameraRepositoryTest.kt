package com.github.mcbeelen.infi.ec.camera

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class CameraRepositoryTest {


    @Test
    fun itShouldReadTheDataFromTheCsv() {

        val cameraRepository = CameraRepository()

        val allCameras = cameraRepository.listAll()

        assertThat(allCameras.size, equalTo(89))
    }




}