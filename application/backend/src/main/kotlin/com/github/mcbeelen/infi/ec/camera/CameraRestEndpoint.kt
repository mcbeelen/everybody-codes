package com.github.mcbeelen.infi.ec.camera

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping("cameras")
class CameraRestEndpoint(private val cameraSearchService: CameraSearchService) {

    @GetMapping()
    fun listCameras(): List<SpeedCamera> = cameraSearchService.listAll()

}