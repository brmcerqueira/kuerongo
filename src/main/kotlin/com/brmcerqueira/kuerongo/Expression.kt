package com.brmcerqueira.kuerongo

open class Expression() : AbstractJson(), IExpression {
    constructor(init: Expression.() -> Unit) : this() {
        init()
    }

    operator fun <T> String.timesAssign(value: T) = this.set(value)

    operator fun String.timesAssign(init: Expression.() -> Unit) = set(this, Expression(), init)

    fun and(vararg expressions: IExpression) {
        wrapper.set("\$and", JsonArray().put(*expressions))
    }

    fun or(vararg expressions: IExpression) {
        wrapper.set("\$or", JsonArray().put(*expressions))
    }

    fun setUnion(vararg expressions: IExpression) {
        wrapper.set("\$setUnion", JsonArray().put(*expressions))
    }

    fun arrayElemAt(expression: IExpression, index: Int) {
        wrapper.set("\$arrayElemAt", JsonArray().put(expression, index))
    }

    fun map(input: String, alias: String, into: String) {
        wrapper.set("\$map", Json {
            "input" *= input
            "as" *= alias
            "in" *= into
        })
    }

    fun reduce(input: String, initialValue: Any, inExpression: Expression.() -> Unit) {
        val expression = Expression()
        expression.inExpression()
        wrapper.set("\$reduce", Json {
            "input" *= input
            "initialValue" *= initialValue
            "in" *= expression
        })
    }

    infix fun geoWithin(init: GeoWithin.() -> Unit) {
        val geoWithin = GeoWithin()
        geoWithin.init()
        wrapper.set("\$geoWithin", geoWithin)
    }

    infix fun <T> eq(value: T) {
        wrapper.set("\$eq", value)
    }

    infix fun <T> gt(value: T) {
        wrapper.set("\$gt", value)
    }

    infix fun <T> gte(value: T) {
        wrapper.set("\$gte", value)
    }

    fun <T> into(value: List<T>) {
        wrapper.set("\$in", value)
    }

    infix fun regex(value: String?) {
        wrapper.set("\$regex", value)
    }

    infix fun <T> lt(value: T) {
        wrapper.set("\$lt", value)
    }

    infix fun <T> lte(value: T) {
        wrapper.set("\$lte", value)
    }

    infix fun <T> ne(value: T) {
        wrapper.set("\$ne", value)
    }

    fun <T> nin(vararg value: T) {
        wrapper.set("\$nin", value)
    }
}