package com.github.mcbeelen.infi.ec.camera

import com.natpryce.hamkrest.MatchResult.Match
import com.natpryce.hamkrest.MatchResult.Mismatch
import com.natpryce.hamkrest.Matcher

class RangeMatcher(private val range: IntRange) : Matcher<SpeedCamera> {
    override val description: String
        get() = "cameraNumber not in ${range.first} .. ${range.last}"

    override fun invoke(camera: SpeedCamera) = if (camera.numberInRange(range)) Match else Mismatch("cameraNumber not in ${range.first} .. ${range.last}")


}

fun SpeedCamera.numberInRange(range: IntRange): Boolean {
    val number = this.cameraNumber.toInt()
    return number in range
}