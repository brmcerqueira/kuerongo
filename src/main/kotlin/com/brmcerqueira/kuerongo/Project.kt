package com.brmcerqueira.kuerongo

class Project : AbstractJson() {
    operator fun String.unaryPlus() {
        raw.set(this, true)
    }

    operator fun String.unaryMinus() {
        raw.set(this, false)
    }

    operator fun String.timesAssign(expression : String) {
        raw.set(this, expression)
    }

    operator fun String.timesAssign(expression : IExpression) {
        raw.set(this, expression)
    }

    operator fun String.timesAssign(init: Project.() -> Unit) = set(this, Project(), init)
}