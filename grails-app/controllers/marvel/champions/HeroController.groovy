package marvel.champions

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import marvel.champions.HeroService

class HeroController {

    HeroService heroService

    static scaffold = Hero
    
    def show(Long id) {
        log.error("Bacon")
        Hero hero = heroService.get(id)
        // int gameCount = heroService.countGames(hero)
        log.error("Game Count: ${hero.heroGames.size()}")
        respond hero //, model: [gameCount: gameCount]
    }

}

