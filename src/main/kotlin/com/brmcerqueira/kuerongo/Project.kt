package com.brmcerqueira.kuerongo

class Project : AbstractJson() {
    operator fun String.unaryPlus() {
        raw.set(this, true)
    }

    operator fun String.unaryMinus() {
        raw.set(this, false)
    }

    operator fun String.remAssign(init: BlockExpression.() -> Unit) = set(this, BlockExpression(), init)

    operator fun String.plusAssign(init: Project.() -> Unit) = set(this, Project(), init)
}