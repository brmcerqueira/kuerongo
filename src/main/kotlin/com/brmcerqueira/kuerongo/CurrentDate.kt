package com.brmcerqueira.kuerongo

class CurrentDate() : AbstractJson() {
    constructor(init: CurrentDate.() -> Unit) : this() {
        init()
    }

    operator fun <T> String.timesAssign(kind: CurrentDateKind) = this.set(when(kind) {
        CurrentDateKind.Timestamp -> Json {
            "\$type" *= "timestamp"
        }
        else -> true
    })
}