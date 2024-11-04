package marvel.champions

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import marvel.champions.HeroService

class HeroController {

    HeroService heroService

    static scaffold = Hero
    
    def show(Long id) {
    Hero hero = heroService.get(id)
    int gameCount = heroService.countGames(id)
    respond hero, model: [gameCount: gameCount]
}

}

