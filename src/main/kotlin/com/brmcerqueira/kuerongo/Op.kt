package com.brmcerqueira.kuerongo

object Op {
    fun eq(left: Any?, right: Any?): IExpression = OperatorExpression {
        "\$eq" *= JsonArray().put(left, right)
    }

    fun cmp(left: Any?, right: Any?): IExpression = OperatorExpression {
        "\$cmp" *= JsonArray().put(left, right)
    }

    fun gt(left: Any?, right: Any?): IExpression = OperatorExpression {
        "\$gt" *= JsonArray().put(left, right)
    }

    fun gte(left: Any?, right: Any?): IExpression = OperatorExpression {
        "\$gte" *= JsonArray().put(left, right)
    }

    fun lt(left: Any?, right: Any?): IExpression = OperatorExpression {
        "\$lt" *= JsonArray().put(left, right)
    }

    fun lte(left: Any?, right: Any?): IExpression = OperatorExpression {
        "\$lte" *= JsonArray().put(left, right)
    }

    fun ne(left: Any?, right: Any?): IExpression = OperatorExpression {
        "\$ne" *= JsonArray().put(left, right)
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

    fun size(expression: IExpression): IExpression = OperatorExpression {
        "\$size" *= expression
    }

    fun arrayElemAt(expression: Any, index: Int): IExpression = OperatorExpression {
        "\$arrayElemAt" *= JsonArray().put(expression, index)
    }

    fun filter(input: Any, conditionExpression: IExpression, alias: String? = null): IExpression = OperatorExpression {
        "\$filter" *= Json {
            "input" *= input
            "cond" *= conditionExpression
            if (alias != null) {
                "as" *= alias
            }
        }
    }

    fun concatArrays(vararg expressions: Any): IExpression = OperatorExpression {
        "\$concatArrays" *= JsonArray().put(*expressions)
    }

    fun replaceRoot(newRoot: IExpression): IExpression = OperatorExpression {
        "\$replaceRoot" *= Json {
            "newRoot" *= newRoot
        }
    }
}