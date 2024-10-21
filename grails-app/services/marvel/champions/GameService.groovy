package marvel.champions

import grails.gorm.services.Service
import static marvel.champions.Game.Aspect
import static marvel.champions.Game.DifficultyLevel
import static marvel.champions.Game.Outcome

@Service(Game)
interface GameService {

    Game save(String name, Hero hero1, Aspect aspect1, Hero hero2, Aspect aspect2, Hero hero3, Aspect aspect3, Hero hero4, Aspect aspect4, Scenario scenario, DifficultyLevel difficultyLevel, ModularSet modularSet, Outcome outcome, int funRating, int difficultyRating, Date date)

}


