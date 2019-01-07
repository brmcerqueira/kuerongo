package com.brmcerqueira.kuerongo

class Project : AbstractJson() {
    operator fun String.unaryPlus() {
        raw.set(this, true)
    }

    operator fun String.unaryMinus() {
        raw.set(this, false)
    }

    infix fun String.expr(init: BlockExpression.() -> Unit) = set(this, BlockExpression(), init)

    operator fun String.remAssign(init: Project.() -> Unit) = set(this, Project(), init)
}