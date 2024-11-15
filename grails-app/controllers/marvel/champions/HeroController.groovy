package marvel.champions

class HeroController {

    HeroService heroService

    static scaffold = Hero

    def show(Long id) {
        log.error('~~~~~~~~~~~~~~~~~~~~~~~~~~~')
        Hero hero = heroService.get(id)
        // int gameCount = heroService.countGames(hero)
        log.error("Game Count: ${hero.heroGames.size()}")
        respond hero //, model: [gameCount: gameCount]

        log.error " avg fun rating for ${hero.heroName} is ${hero.avgFunRating} "

        def averageDifficultyRating = heroService.getAverageDifficultyRatingForHero(hero)
        log.error " avg difficulty rating for ${hero.heroName} is ${averageDifficultyRating} "
    }

}

