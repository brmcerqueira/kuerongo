package com.brmcerqueira.kuerongo

class GroupExpression(kuerongoProvider: KuerongoProvider) : JsonRootBuilder(kuerongoProvider) {
    fun first(expression: String) = json.putUsingMapper("\$first", expression)
    fun push(expression: String) = json.putUsingMapper("\$push", expression)
    fun push(init: Query.() -> Unit) {
        val query = Query(kuerongoProvider)
        query.init()
        json.putUsingMapper("\$push", query.json)
    }
}
