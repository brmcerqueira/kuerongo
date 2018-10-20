package com.brmcerqueira.kuerongo

class Pipeline(kuerongoProvider: KuerongoProvider) : JsonArrayBuilder(kuerongoProvider) {
    constructor(kuerongoProvider: KuerongoProvider, init: Pipeline.() -> Unit) : this(kuerongoProvider) {
        init()
    }

    private fun privateReplaceRoot(newRoot: Any) {
        add(JsonBuilder(kuerongoProvider) {
            "\$replaceRoot" to {
                "newRoot" to newRoot
            }
        })
    }

    fun replaceRoot(newRoot: String) {
        privateReplaceRoot(newRoot)
    }

    fun replaceRoot(newRoot: JsonBuilder.() -> Unit) {
        val jsonBuilder = JsonBuilder(kuerongoProvider)
        jsonBuilder.newRoot()
        privateReplaceRoot(jsonBuilder.json)
    }

    fun unwind(path: String, includeArrayIndex: String? = null, preserveNullAndEmptyArrays: Boolean? = null) {
        add(JsonBuilder(kuerongoProvider) {
            "\$unwind" to {
                "path" to path

                if (!includeArrayIndex.isNullOrBlank()) {
                    "includeArrayIndex" to includeArrayIndex
                }

                if (preserveNullAndEmptyArrays != null) {
                    "preserveNullAndEmptyArrays" to preserveNullAndEmptyArrays
                }
            }
        })
    }

    infix fun match(init: Match.() -> Unit) {
        val match = Match(kuerongoProvider)
        match.init()
        add(JsonBuilder(kuerongoProvider) { "\$match" to match.json })
    }

    infix fun group(init: Group.() -> Unit) {
        val group = Group(kuerongoProvider)
        group.init()
        add(JsonBuilder(kuerongoProvider) { "\$group" to group.json })
    }

    infix fun projection(init: Projection.() -> Unit) {
        val projection = Projection(kuerongoProvider)
        projection.init()
        add(JsonBuilder(kuerongoProvider) { "\$project" to projection.json })
    }

    private fun privateLookup(from: String, alias: String, body: JsonBuilder) {
        body.apply {
            "from" to from
            "as" to alias
        }

        add(JsonBuilder(kuerongoProvider) {
            "\$lookup" to body.json
        })
    }

    fun lookup(from: String, alias: String, localField: String, foreignField: String) {
        privateLookup(from, alias, JsonBuilder(kuerongoProvider) {
            "localField" to localField
            "foreignField" to foreignField
        })
    }

    fun lookup(from: String, alias: String, pipeline: Pipeline, let: JsonBuilder? = null) {
        privateLookup(from, alias, JsonBuilder(kuerongoProvider) {
            "pipeline" to pipeline.json
            if (let != null) {
                "let" to let.json
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
