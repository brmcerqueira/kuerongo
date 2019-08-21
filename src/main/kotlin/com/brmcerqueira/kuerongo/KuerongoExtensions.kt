package com.brmcerqueira.kuerongo

operator fun String.unaryPlus(): StringExpression = StringExpression(this)

operator fun String.not(): StringExpression = StringExpression("\$$this")

operator fun StringExpression.not(): StringExpression = this.prefix("\$")

operator fun StringExpression.div(expression: String): StringExpression = this.suffix(".$expression")

operator fun StringExpression.div(expression: StringExpression): StringExpression = this.suffix(".$expression")