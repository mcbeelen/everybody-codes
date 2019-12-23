package com.github.mcbeelen.infi.ec

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class BackendApplication


fun main(args: Array<String>) {
    runApplication<BackendApplication>(*args)
}
