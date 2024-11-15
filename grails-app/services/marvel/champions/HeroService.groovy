package marvel.champions

import grails.gorm.transactions.Transactional
import grails.gorm.services.Service

@Transactional
@Service(Hero)
abstract class HeroService {

    GameService gameService
    HeroGameService heroGameService

    abstract Hero get(Long id)

    abstract Hero save(String heroName, String alterEgo, boolean ownIt, int gameCount, String release)

    def getAverageFunRatingForHero(Hero hero) {
        List<HeroGame> heroGames = heroGameService.list().findAll { it.hero == hero }

        List<Integer> funRatings = heroGames.collect { it.game.funRating }

        if (funRatings) {
            return funRatings.sum() / funRatings.size()
        } else {
            return ''
        }
    }

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
