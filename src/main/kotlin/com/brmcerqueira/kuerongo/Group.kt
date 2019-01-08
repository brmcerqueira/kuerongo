package com.brmcerqueira.kuerongo

class Group(private val id: IExpression) : AbstractJson() {

    init {
        raw.set("_id", id)
    }

    infix fun String.first(expression: IExpression) {
        raw.set(this, Json {
            "\$first" *= expression
        })
    }

    infix fun String.push(expression: IExpression) {
        raw.set(this, Json {
            "\$push" *= expression
        })
    }

    infix fun String.push(init: Expression.() -> Unit) {
        val query = Expression()
        query.init()
        raw.set(this, Json {
            "\$push" *= query
        })
    }
}