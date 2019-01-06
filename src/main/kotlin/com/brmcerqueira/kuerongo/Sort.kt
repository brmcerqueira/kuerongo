package com.brmcerqueira.kuerongo

class Sort : AbstractJson() {
    operator fun String.unaryPlus() {
        raw.set(this, 1)
    }

    operator fun String.unaryMinus() {
        raw.set(this, -1)
    }

    infix fun String.to(init: Sort.() -> Unit) = to(this, Sort(), init)
}