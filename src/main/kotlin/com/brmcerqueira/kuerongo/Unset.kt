package com.brmcerqueira.kuerongo

class Unset() : AbstractJson() {
    constructor(init: Unset.() -> Unit) : this() {
        init()
    }

    operator fun String.unaryMinus() {
        wrapper.set(this, "")
    }
}