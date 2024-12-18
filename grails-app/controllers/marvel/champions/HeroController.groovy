package marvel.champions

class HeroController {

    HeroService heroService

    static scaffold = Hero

    def show(Long id) {
        Hero hero = heroService.get(id)
        if (!hero) {
            flash.message = "Hero not found"
            return
        }
        // int gameCount = heroService.countGames(hero)
        // log.error("Game Count: ${hero.heroGames.size()}")
        respond hero //, model: [gameCount: gameCount]

        // log.error " avg fun rating for ${hero.heroName} is ${hero.avgFunRating} "

        // log.error " avg difficulty rating for ${hero.heroName} is ${hero.avgDifficultyRating} "
    }

}
