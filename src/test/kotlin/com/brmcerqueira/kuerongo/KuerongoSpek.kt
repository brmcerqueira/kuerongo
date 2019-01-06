package com.brmcerqueira.kuerongo

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object KuerongoSpek : Spek({
    describe("Testando o raw") {
        println(Pipeline {
            match {
                "email" to "brmcerqueira@gmail.com"
                "enabled" to true
            }

            unwind("\$profiles")

            lookup("profile", "lookup_profiles", Pipeline {
                match {
                    "enabled" to true
                    expr {
                        and(eq("\$_id", "\$\$id"))
                    }
                }
                unwind("\$permissions")
                project {
                    -"_id"
                    +"permissions"
                }
            }, Json {
                "id" to "\$profiles"
            })

            group(!"\$_id") {
                "password" first !"\$password"
                "kind" first !"\$kind"
                "group_permissions" push {
                    map("\$lookup_profiles", "profile", "\$\$profile.permissions")
                }
            }

            project {
                +"password"
                +"kind"
                "permissions" ex {
                    reduce("\$group_permissions", JsonArray()) {
                        setUnion(!"\$\$value", !"\$\$this")
                    }
                }
            }
        })
    }
})