package com.brmcerqueira.kuerongo

operator fun String.not(): StringExpression = StringExpression(this)

fun expr(init: Expression.() -> Unit): Expression {
    val expression = Expression()
    expression.init()
    return expression
}

fun eq(left: Any?, right: Any?): IExpression = OperatorExpression {
    "\$eq" *= JsonArray().put(left, right)
}

fun cond(conditionExpression: IExpression, trueResult: Any?, falseResult: Any?): IExpression = OperatorExpression {
    "\$cond" *= Json {
        "if" *= conditionExpression
        "then" *= trueResult
        "else" *= falseResult
    }
}