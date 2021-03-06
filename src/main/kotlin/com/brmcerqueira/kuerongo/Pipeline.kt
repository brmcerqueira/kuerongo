package com.brmcerqueira.kuerongo

class Pipeline : AbstractJsonArray {
    constructor(init: Pipeline.() -> Unit) {
        init()
    }

    fun replaceRoot(newRoot: IExpression) {
        add(Json {
            "\$replaceRoot" *= {
                "newRoot" *= newRoot
            }
        })
    }

    fun unwind(path: IExpression, includeArrayIndex: String? = null, preserveNullAndEmptyArrays: Boolean? = null) {
        add(Json {
            "\$unwind" *= {
                "path" *= path

                if (!includeArrayIndex.isNullOrBlank()) {
                    "includeArrayIndex" *= includeArrayIndex
                }

                if (preserveNullAndEmptyArrays != null) {
                    "preserveNullAndEmptyArrays" *= preserveNullAndEmptyArrays
                }
            }
        })
    }

    infix fun addField(init: Json.() -> Unit){
        val json = Json()
        json.init()
        add(Json {
            "\$addFields" *= json
        })
    }

    infix fun match(init: Match.() -> Unit) {
        val match = Match()
        match.init()
        add(Json {
            "\$match" *= match
        })
    }

    fun group(init: Group.() -> Unit) = group(null, init)

    fun group(id: IExpression?, init: Group.() -> Unit) {
        val group = Group(id)
        group.init()
        add(Json {
            "\$group" *= group
        })
    }

    infix fun project(init: Project.() -> Unit) {
        val project = Project()
        project.init()
        add(Json {
            "\$project" *= project
        })
    }

    fun sort(init: Sort.() -> Unit) {
        add(Json {
            "\$sort" *= Sort(init)
        })
    }

    private fun privateLookup(from: String, alias: String, json: Json) {
        json.apply {
            "from" *= from
            "as" *= alias
        }

        add(Json {
            "\$lookup" *= json
        })
    }

    fun lookup(from: String, alias: String, localField: String, foreignField: String) {
        privateLookup(from, alias, Json {
            "localField" *= localField
            "foreignField" *= foreignField
        })
    }

    fun lookup(from: String, alias: String, pipeline: Pipeline, let: Json? = null) {
        privateLookup(from, alias, Json {
            "pipeline" *= pipeline
            if (let != null) {
                "let" *= let
            }
        })
    }

    fun graphLookup(from: String, alias: String, connectFromField: String, connectToField: String, startWith: IExpression,
                    maxDepth: Int? = null, depthField: String? = null, restrictSearchWithMatch: Json? = null) {
        add(Json {
            "\$graphLookup" *= Json {
                "from" *= from
                "as" *= alias
                "connectFromField" *= connectFromField
                "connectToField" *= connectToField
                "startWith" *= startWith
                if (maxDepth != null) {
                    "maxDepth" *= maxDepth
                }
                if (depthField != null) {
                    "depthField" *= depthField
                }
                if (restrictSearchWithMatch != null) {
                    "restrictSearchWithMatch" *= restrictSearchWithMatch
                }
            }
        })
    }

    fun limit(value: Int) {
        add(Json {
            "\$limit" *= value
        })
    }

    fun skip(value: Int) {
        add(Json {
            "\$skip" *= value
        })
    }
}
