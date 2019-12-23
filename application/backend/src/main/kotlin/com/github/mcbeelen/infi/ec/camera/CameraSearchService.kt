package com.github.mcbeelen.infi.ec.camera

import org.springframework.stereotype.Service

@Service
class CameraSearchService(private val cameraRepository: CameraRepository) {

    fun findCamerasByName(partialName: String) : List<SpeedCamera> {
        val partialNameIndex = partialName.toUpperCase()
        return cameraRepository.listAll().filter { it.descriptionIndex.contains(partialNameIndex) }
}

    fun listAll(): List<SpeedCamera> = cameraRepository.listAll()

}
