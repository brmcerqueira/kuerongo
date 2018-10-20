package com.brmcerqueira.kuerongo

class ArrayExpression(kuerongoProvider: KuerongoProvider) : JsonArrayBuilder(kuerongoProvider) {
    operator fun String.not() = json.addUsingMapper(this)

    fun eq(leftExpression: String, rightExpression: String) {
        add(JsonBuilder(this@ArrayExpression.kuerongoProvider) {
            "\$eq" to this@ArrayExpression.kuerongoProvider.createJsonArray()
                    .addUsingMapper(leftExpression).addUsingMapper(rightExpression)
        })
    }

    fun add(init: Query.() -> Unit) {
        val query = Query(kuerongoProvider)
        query.init()
        json.addUsingMapper(query.json)
    }
}
