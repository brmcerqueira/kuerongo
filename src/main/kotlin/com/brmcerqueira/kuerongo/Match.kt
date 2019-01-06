package com.brmcerqueira.kuerongo

class Match : Query() {
    infix fun expr(init: Query.() -> Unit) {
        val query = Query()
        query.init()
        raw.set("\$expr", query)
    }
}