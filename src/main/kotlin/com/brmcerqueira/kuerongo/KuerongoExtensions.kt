package com.brmcerqueira.kuerongo

operator fun String.not(): StringExpression = StringExpression(this)

fun eq(left: Any?, right: Any?): IExpression = Expression {
    "\$eq" to JsonArray().put(left, right)
}

fun cond(conditionExpression: IExpression, trueResult: Any?, falseResult: Any?): IExpression = Expression {
    "\$cond" to Json {
        "if" to conditionExpression
        "then" to trueResult
        "else" to falseResult
    }
}