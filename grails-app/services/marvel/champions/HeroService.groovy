package marvel.champions

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Transactional
@Service(Hero)
abstract class HeroService {
    
    GameService gameService

    abstract Hero get(Long id)
    
    abstract Hero save(String heroName, String alterEgo, boolean ownIt, int gameCount, String release)
      
    // int countGames(Hero hero) {    
    //     return gameService.countByHero1(hero)
    // }
}
