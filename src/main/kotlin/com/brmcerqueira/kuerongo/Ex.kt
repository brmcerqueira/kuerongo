package com.brmcerqueira.kuerongo

open class Ex() : AbstractJson(), IExpression {
    constructor(init: Ex.() -> Unit) : this() {
        init()
    }

    operator fun <T> String.timesAssign(value: T) = this.set(value)

    operator fun String.timesAssign(init: Ex.() -> Unit) = set(this, Ex(), init)

    fun and(vararg expressions: IExpression) {
        wrapper.set("\$and", JsonArray().put(*expressions))
    }

    fun or(vararg expressions: IExpression) {
        wrapper.set("\$or", JsonArray().put(*expressions))
    }

    fun setUnion(vararg expressions: IExpression) {
        wrapper.set("\$setUnion", JsonArray().put(*expressions))
    }

    fun map(input: IExpression, alias: String, into: IExpression) {
        wrapper.set("\$map", Json {
            "input" *= input
            "as" *= alias
            "in" *= into
        })
    }

    fun reduce(input: IExpression, initialValue: Any, inExpression: Ex.() -> Unit) {
        val expression = Ex()
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

    fun text(search: String, caseSensitive: Boolean = false, diacriticSensitive: Boolean = false, language: String? = null) {
        wrapper.set("\$text", Json {
            "\$search" *= search
            "\$caseSensitive" *= caseSensitive
            "\$diacriticSensitive"*= diacriticSensitive
            if (language != null) {
                "\$language"*= language
            }
        })
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

    fun <T> varargInto(vararg value: T) {
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

    fun <T> nin(value: List<T>) {
        wrapper.set("\$nin", value)
    }

    fun <T> varargNin(vararg value: T) {
        wrapper.set("\$nin", value)
    }
}