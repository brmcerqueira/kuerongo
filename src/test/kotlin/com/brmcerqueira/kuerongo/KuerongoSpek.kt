package com.brmcerqueira.kuerongo

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object KuerongoSpek : Spek({
    describe("Testando o wrapper") {
        println(Pipeline {
            match {
                "email" *= "brmcerqueira@gmail.com"
                "enabled" *= true
                "location" *= {
                    geoWithin {
                        centerSphere(-27.6343625, -48.4582849 , 5 / 3963.2)
                    }
                }
            }

            unwind("\$profiles")

            lookup("profile", "lookup_profiles", Pipeline {
                match {
                    "enabled" *= true
                    expr {
                        and(Ex.eq("\$_id", "\$\$id"))
                    }
                }
                unwind("\$permissions")
                project {
                    -"_id"
                    +"permissions"
                }
            }, Json {
                "id" *= "\$profiles"
            })

            group(!"\$_id") {
                "password" first "\$password"
                "kind" first "\$kind"
                "group_permissions" push {
                    map("\$lookup_profiles", "profile", "\$\$profile.permissions")
                }
            }

            project {
                +"password"
                +"kind"
                "permissions" *= Ex.new {
                    reduce("\$group_permissions", JsonArray()) {
                        setUnion(!"\$\$value", !"\$\$this")
                    }
                }
            }
        })
    }
})