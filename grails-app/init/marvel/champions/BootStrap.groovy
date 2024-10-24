package marvel.champions

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    GameService gameService
    HeroService heroService
    ModularSetService modularSetService 
    ScenarioService scenarioService 

    def init = { servletContext ->

        Hero spiderMan = heroService.save("Spider-Man", "Peter Parker", true, 5, "0")
        Hero ironMan = heroService.save("Iron-Man", "Tony Stark", true, 3, "0")

        ModularSet bombScare = modularSetService.save("Bomb Scare", "Bmb Scr")
        ModularSet hydraPatrol = modularSetService.save("Hydra Patrol","Hydr Ptrl")

        Scenario rhino = scenarioService.save("Rhino")

    }
    def destroy = {
    }
}
