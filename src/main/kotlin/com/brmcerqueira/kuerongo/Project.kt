package com.brmcerqueira.kuerongo

class Project : AbstractJson() {
    operator fun String.unaryPlus() {
        raw.set(this, true)
    }

    operator fun String.unaryMinus() {
        raw.set(this, false)
    }

    infix fun String.ex(init: Query.() -> Unit) = set(this, Query(), init)

    infix fun String.to(init: Project.() -> Unit) = set(this, Project(), init)
}