package com.brmcerqueira.kuerongo

class Group(kuerongoProvider: KuerongoProvider) : JsonRootBuilder(kuerongoProvider) {
    infix fun String.to(init: GroupExpression.() -> Unit) = to(this, GroupExpression(kuerongoProvider), init)
}
