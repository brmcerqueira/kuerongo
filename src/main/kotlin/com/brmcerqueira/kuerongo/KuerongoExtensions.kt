package com.brmcerqueira.kuerongo

operator fun String.not(): StringExpression = StringExpression(this)