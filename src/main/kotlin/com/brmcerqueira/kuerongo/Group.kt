package com.brmcerqueira.kuerongo

class Group(private val id: IExpression) : AbstractJson() {

    init {
        raw.set("_id", id)
    }

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

    infix fun String.push(init: BlockExpression.() -> Unit) {
        val query = BlockExpression()
        query.init()
        raw.set(this, Json {
            "\$push" to query
        })
    }
}