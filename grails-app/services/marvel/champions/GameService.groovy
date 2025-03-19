package marvel.champions

import grails.gorm.services.Service

import static marvel.champions.Game.DifficultyLevel
import static marvel.champions.Game.Outcome

@Service(Game)
abstract class GameService {

    abstract Game get(Serializable id)

    def findAllByUser(User user) {
        Game.findAllByUser(user)
    }

    def findByTempId(String tempId) {
        Game.findByTempId(tempId)
    }

    abstract Long count()

    abstract void delete(Serializable id)

    abstract Game save(Scenario scenario, DifficultyLevel difficultyLevel, ModularSet modularSet, Outcome outcome, int funRating, int difficultyRating)

    abstract Game save(Game game)

}
