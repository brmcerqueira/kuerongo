package com.brmcerqueira.kuerongo

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object KuerongoSpek : Spek({
    describe("Testando o raw") {
        println(Json {
            "name" to "value"
            "index" to 12
        })
    }
})