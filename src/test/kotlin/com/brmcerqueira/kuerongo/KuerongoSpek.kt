package com.brmcerqueira.kuerongo

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object KuerongoSpek : Spek({
    describe("Testando o raw") {
        println(Query {
            and(eq(!"\$index", !10))
        })
    }
})