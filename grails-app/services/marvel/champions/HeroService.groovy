package marvel.champions

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Transactional
@Service(Hero)
abstract class HeroService {

    GameService gameService
    HeroGameService heroGameService

    abstract Hero get(Long id)

    abstract Hero save(String heroName, String alterEgo, boolean ownIt, String release)

    // abstract Hero save(Hero hero)

    // int countGames(Hero hero) {
    //     return gameService.countByHero1(hero)
    // }

}
