package marvel.champions

import grails.gorm.services.Service

import static marvel.champions.Game.DifficultyLevel
import static marvel.champions.Game.Outcome

@Service(Game)
abstract class GameService {

    abstract Game get(Serializable id)

    abstract List<Game> list(Map args)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Game save(String name, Scenario scenario, DifficultyLevel difficultyLevel, ModularSet modularSet, Outcome outcome, int funRating, int difficultyRating)

    abstract Game save(Game game)

}
