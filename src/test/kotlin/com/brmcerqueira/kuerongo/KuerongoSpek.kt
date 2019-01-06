package com.brmcerqueira.kuerongo

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object KuerongoSpek : Spek({
    describe("Testando o raw") {
        println(Query {
            and(cond(!"\$index", eq(20, 10), eq(10, 10)) )
        })
    }
})