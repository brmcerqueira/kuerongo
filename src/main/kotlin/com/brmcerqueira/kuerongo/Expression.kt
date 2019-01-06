package com.brmcerqueira.kuerongo

class Expression : AbstractJson() {
    fun and(vararg expressions: Expression) {
        raw.set("\$and", JsonArray().put(*expressions))
    }

    fun or(vararg expressions: Expression) {
        raw.set("\$or", JsonArray().put(*expressions))
    }

    fun setUnion(vararg expressions: Expression) {
        raw.set("\$setUnion", JsonArray().put(*expressions))
    }

    fun arrayElemAt(expression: String, index: Int) = raw.set("\$arrayElemAt", JsonArray().put(expression, index))

    fun map(input: String, alias: String, into: String) = raw.set("\$map", Json {
        "input" to input
        "as" to alias
        "in" to into
    })

    fun reduce(input: String, initialValue: Any, inExpression: Expression.() -> Unit) {
        val expression = Expression()
        expression.inExpression()
        raw.set("\$reduce", Json {
            "input" to input
            "initialValue" to initialValue
            "in" to expression
        })
    }

    infix fun <T> eq(value: T) {
        raw.set("\$eq", value)
    }

    infix fun <T> gt(value: T) {
        raw.set("\$gt", value)
    }

    infix fun <T> gte(value: T) {
        raw.set("\$gte", value)
    }

    fun <T> into(value: List<T>) {
        raw.set("\$in", value)
    }

    infix fun regex(value: String?) {
        raw.set("\$regex", value)
    }

    infix fun <T> lt(value: T) {
        raw.set("\$lt", value)
    }

    infix fun <T> lte(value: T) {
        raw.set("\$lte", value)
    }

    infix fun <T> ne(value: T) {
        raw.set("\$ne", value)
    }

    fun <T> nin(vararg value: T) {
        raw.set("\$nin", value)
    }
}