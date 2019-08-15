package com.brmcerqueira.kuerongo

class Project : AbstractJson() {
    operator fun String.unaryPlus() {
        wrapper.set(this, true)
    }

    operator fun String.unaryMinus() {
        wrapper.set(this, false)
    }

    operator fun String.timesAssign(expression: Any) {
        wrapper.set(this, expression)
    }

    operator fun String.timesAssign(init: Project.() -> Unit) = set(this, Project(), init)
}