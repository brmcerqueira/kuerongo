package com.brmcerqueira.kuerongo

class Pipeline : AbstracJsonArray {
    constructor(init: Pipeline.() -> Unit) {
        init()
    }

    private fun privateReplaceRoot(newRoot: Any) {
        add(Json {
            "\$replaceRoot" *= {
                "newRoot" *= newRoot
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

    fun group(id: IExpression, init: Group.() -> Unit) {
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
        val sort = Sort()
        sort.init()
        add(Json {
            "\$sort" *= sort
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
