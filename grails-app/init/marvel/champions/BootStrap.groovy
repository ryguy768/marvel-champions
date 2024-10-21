package marvel.champions

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    GameService gameService
    HeroService heroService
    ModularSetService modularsetService 
    ScenarioService scenarioService 

    def init = { servletContext ->

        Hero spiderMan = heroService.save("Spider-Man", "Peter Parker", true, 5, "0")

    }
    def destroy = {
    }
}
