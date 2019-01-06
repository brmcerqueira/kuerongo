package com.brmcerqueira.kuerongo

class Pipeline : AbstracJsonArray {
    constructor(init: Pipeline.() -> Unit) {
        init()
    }

    private fun privateReplaceRoot(newRoot: Any) {
        add(Json {
            "\$replaceRoot" to {
                "newRoot" to newRoot
            }
        })
    }

    fun replaceRoot(newRoot: String) {
        privateReplaceRoot(newRoot)
    }

    fun replaceRoot(init: Json.() -> Unit) {
        val json = Json()
        json.init()
        privateReplaceRoot(json.raw)
    }

    fun unwind(path: String, includeArrayIndex: String? = null, preserveNullAndEmptyArrays: Boolean? = null) {
        add(Json {
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

    infix fun addField(init: Json.() -> Unit){
        val json = Json()
        json.init()
        add(Json {
            "\$addFields" to json.raw
        })
    }

    infix fun match(init: Json.() -> Unit) {
        val json = Json()
        json.init()
        add(Json {
            "\$match" to json.raw
        })
    }

    infix fun group(init: Json.() -> Unit) {
        val json = Json()
        json.init()
        add(Json {
            "\$group" to json.raw
        })
    }

    infix fun project(init: Project.() -> Unit) {
        val project = Project()
        project.init()
        add(Json {
            "\$project" to project.raw
        })
    }

    fun sort(init: Sort.() -> Unit) {
        val sort = Sort()
        sort.init()
        add(Json {
            "\$sort" to sort.raw
        })
    }

    private fun privateLookup(from: String, alias: String, json: Json) {
        json.apply {
            "from" to from
            "as" to alias
        }

        add(Json {
            "\$lookup" to json.raw
        })
    }

    fun lookup(from: String, alias: String, localField: String, foreignField: String) {
        privateLookup(from, alias, Json {
            "localField" to localField
            "foreignField" to foreignField
        })
    }

    fun lookup(from: String, alias: String, pipeline: Pipeline, let: Json? = null) {
        privateLookup(from, alias, Json {
            "pipeline" to pipeline.raw
            if (let != null) {
                "let" to let.raw
            }
        })
    }

    fun limit(value: Int) {
        add(Json {
            "\$limit" to value
        })
    }

    fun skip(value: Int) {
        add(Json {
            "\$skip" to value
        })
    }
}
