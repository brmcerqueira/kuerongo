package com.brmcerqueira.kuerongo

class Match : BlockExpression() {
    infix fun expr(init: BlockExpression.() -> Unit) {
        val query = BlockExpression()
        query.init()
        raw.set("\$expr", query)
    }
}