package com.brmcerqueira.kuerongo

object Op {
    fun eq(left: Any?, right: Any?): IExpression = OperatorExpression {
        "\$eq" *= JsonArray().put(left, right)
    }

    fun and(vararg expressions: IExpression): IExpression = OperatorExpression {
        "\$and" *= JsonArray().put(*expressions)
    }

    fun or(vararg expressions: IExpression): IExpression = OperatorExpression {
        "\$or" *= JsonArray().put(*expressions)
    }

    fun cond(conditionExpression: IExpression, trueResult: Any?, falseResult: Any?): IExpression = OperatorExpression {
        "\$cond" *= Json {
            "if" *= conditionExpression
            "then" *= trueResult
            "else" *= falseResult
        }
    }
}