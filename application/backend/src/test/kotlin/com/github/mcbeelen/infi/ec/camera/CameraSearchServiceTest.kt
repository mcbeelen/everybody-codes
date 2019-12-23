package com.github.mcbeelen.infi.ec.camera

import com.natpryce.hamkrest.Matcher
import com.natpryce.hamkrest.allElements
import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class CameraSearchServiceTest {

    @Test
    fun itShouldReturnSixCamerasForNeude() {

        val cameraSearchService = CameraSearchService(buildCsvCameraRepositoryForTests())
        val camerasForNeude = cameraSearchService.findCamerasByName("Neude")
        assertThat(camerasForNeude.size, equalTo(6))
        assertThat(camerasForNeude, allElements(cameraNumberInRange(501 .. 507)))

    }

    private fun cameraNumberInRange(range: IntRange): Matcher<SpeedCamera> {
       return RangeMatcher(range)
    }


}
