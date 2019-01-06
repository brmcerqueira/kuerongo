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
        privateReplaceRoot(json)
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
            "\$addFields" to json
        })
    }

    infix fun match(init: Match.() -> Unit) {
        val match = Match()
        match.init()
        add(Json {
            "\$match" to match
        })
    }

    fun group(id: IExpression, init: Group.() -> Unit) {
        val group = Group(id)
        group.init()
        add(Json {
            "\$group" to group
        })
    }

    infix fun project(init: Project.() -> Unit) {
        val project = Project()
        project.init()
        add(Json {
            "\$project" to project
        })
    }

    fun sort(init: Sort.() -> Unit) {
        val sort = Sort()
        sort.init()
        add(Json {
            "\$sort" to sort
        })
    }

    private fun privateLookup(from: String, alias: String, json: Json) {
        json.apply {
            "from" to from
            "as" to alias
        }

        add(Json {
            "\$lookup" to json
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
            "pipeline" to pipeline
            if (let != null) {
                "let" to let
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
