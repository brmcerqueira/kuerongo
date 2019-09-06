package com.brmcerqueira.kuerongo

class Sort() : AbstractJson() {
    constructor(init: Sort.() -> Unit) : this() {
        init()
    }

    operator fun String.unaryPlus() {
        wrapper.set(this, 1)
    }

    operator fun String.unaryMinus() {
        wrapper.set(this, -1)
    }
}