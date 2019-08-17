package com.brmcerqueira.kuerongo

class Match : Ex() {
    infix fun expr(init: Ex.() -> Unit) {
        val query = Ex()
        query.init()
        wrapper.set("\$expr", query)
    }
}