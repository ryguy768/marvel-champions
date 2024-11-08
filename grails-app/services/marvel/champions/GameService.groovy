package marvel.champions

import grails.gorm.services.Service
import static marvel.champions.Game.Aspect
import static marvel.champions.Game.DifficultyLevel
import static marvel.champions.Game.Outcome

@Service(Game)
interface GameService {

    Game save(String name, Scenario scenario, DifficultyLevel difficultyLevel, ModularSet modularSet, Outcome outcome, int funRating, int difficultyRating)

    Game save(Game game)
    // int countByHero1(Hero hero)

}
