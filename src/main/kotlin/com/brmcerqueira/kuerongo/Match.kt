package com.brmcerqueira.kuerongo

class Match : Expression() {
    infix fun expr(init: Expression.() -> Unit) {
        val query = Expression()
        query.init()
        raw.set("\$expr", query)
    }
}