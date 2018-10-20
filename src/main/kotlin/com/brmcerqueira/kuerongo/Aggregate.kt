package com.brmcerqueira.kuerongo

@JsonMarker
class Aggregate(protected val kuerongoProvider: KuerongoProvider) {
    val json = kuerongoProvider.createJsonArray()

    constructor(kuerongoProvider: KuerongoProvider, init: Aggregate.() -> Unit) : this(kuerongoProvider) {
        init()
    }

    private fun add(jsonBuilder: JsonBuilder) = json.addUsingMapper(jsonBuilder.json)

    infix fun match(init: Query.() -> Unit) {
        val query = Query(kuerongoProvider)
        query.init()
        add(JsonBuilder(kuerongoProvider) { "\$match" to query.json })
    }

    infix fun projection(init: Projection.() -> Unit) {
        val projection = Projection(kuerongoProvider)
        projection.init()
        add(JsonBuilder(kuerongoProvider) { "\$project" to projection.json })
    }

    fun lookup(from: String, localField: String, foreignField: String, alias: String) {
        add(JsonBuilder(kuerongoProvider) {
            "\$lookup" to {
                "from" to from
                "localField" to localField
                "foreignField" to foreignField
                "as" to alias
            }
        })
    }

    fun limit(value: Int) {
        add(JsonBuilder(kuerongoProvider) { "\$limit" to value})
    }

    fun skip(value: Int) {
        add(JsonBuilder(kuerongoProvider) { "\$skip" to value})
    }
}
