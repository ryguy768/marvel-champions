package marvel.champions

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "login", action: "auth")
        "500"(view: '/error')
        "404"(view: '/notFound')
        "/heroGame/createAsync"(controller: "heroGame", action: "createAsync")
    }
}
