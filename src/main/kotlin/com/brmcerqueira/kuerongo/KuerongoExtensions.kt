package com.brmcerqueira.kuerongo

operator fun String.not(): LiteralExpression = LiteralExpression(this)

operator fun Int.not(): LiteralExpression = LiteralExpression(this)

fun eq(leftExpression: IExpression, rightExpression: IExpression): IExpression {
    return Expression {
        "\$eq" to JsonArray().put(leftExpression, rightExpression)
    }
}