package com.brmcerqueira.kuerongo

class Push() : AbstractJson() {
    constructor(init: Push.() -> Unit) : this() {
        init()
    }

    operator fun <T> String.timesAssign(value: T) = this.set(value)

    operator fun String.timesAssign(init: PushField.() -> Unit) = set(this, PushField(), init)
}