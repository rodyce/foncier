package org.rodyce.foncier

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FoncierApplication

fun main(args: Array<String>) {
	runApplication<FoncierApplication>(*args)
}
