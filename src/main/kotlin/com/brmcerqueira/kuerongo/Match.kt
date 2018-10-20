package com.brmcerqueira.kuerongo

class Match(kuerongoProvider: KuerongoProvider) : Query(kuerongoProvider) {
    infix fun expr(init: Query.() -> Unit) {
        val query = Query(kuerongoProvider)
        query.init()
        putOp("expr", query.json)
    }
}
