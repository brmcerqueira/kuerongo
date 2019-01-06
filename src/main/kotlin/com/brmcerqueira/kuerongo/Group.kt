package com.brmcerqueira.kuerongo

class Group : AbstractJson() {
    infix fun String.first(expression: IExpression) {
        raw.set(this, Json {
            "\$first" to expression
        })
    }

    infix fun String.push(expression: IExpression) {
        raw.set(this, Json {
            "\$push" to expression
        })
    }

    fun String.push(init: Query.() -> Unit) {
        val query = Query()
        query.init()
        raw.set(this, Json {
            "\$push" to query
        })
    }
}