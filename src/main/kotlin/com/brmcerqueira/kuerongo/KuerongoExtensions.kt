package com.brmcerqueira.kuerongo

operator fun String.unaryPlus(): StringExpression = StringExpression(this)

operator fun String.not(): StringExpression = StringExpression("\$$this")

operator fun StringExpression.not(): StringExpression = this.prefix("\$")

operator fun StringExpression.div(expression: String): StringExpression = this.suffix(".$expression")

operator fun StringExpression.div(expression: StringExpression): StringExpression = this.suffix(".$expression")

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