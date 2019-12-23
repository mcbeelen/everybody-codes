package com.github.mcbeelen.infi.ec.camera

class CameraSeachService(private val cameraRepository: CameraRepository) {

    fun findCamerasByName(partialName: String) : List<SpeedCamera> {
        val partialNameIndex = partialName.toUpperCase()
        return cameraRepository.listAll().filter { it.descriptionIndex.contains(partialNameIndex) }
}

}
