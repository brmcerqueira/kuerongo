package com.brmcerqueira.kuerongo

import com.brmcerqueira.kuerongo.config.IJsonRaw
import com.brmcerqueira.kuerongo.config.KuerongoConfig

class LiteralExpression(private val value: Any?) : IExpression {
    override val raw: IJsonRaw
        get() = KuerongoConfig.kuerongoProvider.createLiteral(value)
}