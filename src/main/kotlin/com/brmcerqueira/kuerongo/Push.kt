package com.brmcerqueira.kuerongo

class Push() : AbstractJson() {
    constructor(init: Push.() -> Unit) : this() {
        init()
    }

    operator fun String.timesAssign(expression: Any) {
        wrapper.set(this, expression)
    }

    operator fun String.timesAssign(init: PushField.() -> Unit) = set(this, PushField(), init)
}