package com.brmcerqueira.kuerongo

class Group(private val id: IExpression?) : AbstractJson() {

    init {
        wrapper.set("_id", id)
    }

    infix fun String.first(expression: String) = this.first(!expression)

    infix fun String.first(expression: IExpression) {
        wrapper.set(this, Json {
            "\$first" *= expression
        })
    }

    infix fun String.sum(expression: Any) = this.privateSum(expression)

    infix fun String.sum(expressions: Array<Any>) = this.privateSum(*expressions)

    private fun String.privateSum(vararg expressions: Any) {
        wrapper.set(this, Json {
            "\$sum" *= if (expressions.size == 1) expressions.first() else JsonArray().put(*expressions)
        })
    }

    infix fun String.push(expression: String) = this.push(!expression)

    infix fun String.push(expression: IExpression) {
        wrapper.set(this, Json {
            "\$push" *= expression
        })
    }

    infix fun String.push(init: Expression.() -> Unit) {
        val query = Expression()
        query.init()
        wrapper.set(this, Json {
            "\$push" *= query
        })
    }
}