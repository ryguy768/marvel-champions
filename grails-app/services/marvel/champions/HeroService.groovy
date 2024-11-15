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

    def getAverageDifficultyRatingForHero(Hero hero) {
        List<HeroGame> heroGames = heroGameService.list().findAll { it.hero == hero }

        List<Integer> difficultyRatings = heroGames.collect { it.game.difficultyRating }

        if (difficultyRatings) {
            return difficultyRatings.sum() / difficultyRatings.size()
        } else {
            return ''
        }
    }

    // abstract Hero save(Hero hero)

    // int countGames(Hero hero) {
    //     return gameService.countByHero1(hero)
    // }

}
