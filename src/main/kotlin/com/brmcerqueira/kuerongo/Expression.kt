package com.brmcerqueira.kuerongo

abstract class Expression(kuerongoProvider: KuerongoProvider) : JsonRootBuilder(kuerongoProvider){
    fun and(init: ArrayExpression.() -> Unit) {
        val arrayExpression = ArrayExpression(kuerongoProvider)
        arrayExpression.init()
        json.putUsingMapper("\$and", arrayExpression.json)
    }

    fun or(init: ArrayExpression.() -> Unit) {
        val arrayExpression = ArrayExpression(kuerongoProvider)
        arrayExpression.init()
        json.putUsingMapper("\$or", arrayExpression.json)
    }

    fun setUnion(init: ArrayExpression.() -> Unit) {
        val arrayExpression = ArrayExpression(kuerongoProvider)
        arrayExpression.init()
        json.putUsingMapper("\$setUnion", arrayExpression.json)
    }

    fun arrayElemAt(expression: String, index: Int) = json.putUsingMapper("\$arrayElemAt",
            kuerongoProvider.createJsonArray().addUsingMapper(expression).addUsingMapper(index))

    fun map(input: String, alias: String, inn: String) = json.putUsingMapper("\$map", JsonBuilder(kuerongoProvider) {
        "input" to input
        "as" to alias
        "in" to inn
    }.json)

    fun reduce(input: String, initialValue: Any, inInit: Query.() -> Unit) {
        val query = Query(kuerongoProvider)
        query.inInit()
        json.putUsingMapper("\$reduce", JsonBuilder(kuerongoProvider) {
            "input" to input
            "initialValue" to initialValue
            "in" to query.json
        }.json)
    }

    protected fun <T : Any?> putOp(op: String, value: T) {
        if (value != null) {
            json.putUsingMapper("\$$op", value)
        }
    }

    infix fun <T> eq(value: T) {
        this.putOp("eq", value)
    }

    infix fun <T> gt(value: T) {
        this.putOp("gt", value)
    }

    infix fun <T> gte(value: T) {
        this.putOp("gte", value)
    }

    fun <T> into(value: List<T>?) {
        if (value != null) {
            json.putUsingMapper("\$in", value)
        }
    }

    infix fun regex(value: String?) {
        this.putOp("regex", value)
    }

    infix fun <T> lt(value: T) {
        this.putOp("lt", value)
    }

    infix fun <T> lte(value: T) {
        this.putOp("lte", value)
    }

    infix fun <T> ne(value: T) {
        this.putOp("ne", value)
    }

    fun <T> nin(vararg value: T) {
        this.putOp("nin", value)
    }
}
