package org.rodyce.foncier.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SomeController {
    @GetMapping("/")
    fun all(): String {
        return "foncier"
    }
}
