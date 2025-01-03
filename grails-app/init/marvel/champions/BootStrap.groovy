/* groovylint-disable NglParseError, UnusedVariable */
package marvel.champions


import groovy.transform.CompileStatic
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import marvel.champions.*

@CompileStatic
class BootStrap {


    GameService gameService
    HeroService heroService
    ModularSetService modularSetService
    ScenarioService scenarioService

    def init = { servletContext ->

        def adminRole = new Role(authority: 'ROLE_ADMIN').save()
        def userRole = new Role(authority: 'ROLE_USER').save()

        def adminUser = new User(username: 'admin', password: 'admin').save()
        def guestUser = new User(username: 'guest', password: 'guest').save()

        UserRole.create(adminUser, adminRole)
        UserRole.create(guestUser, userRole)


        if (!Hero.findByHeroName('Spider-Man')) {
            new Hero(
                    heroName: 'Spider-Man',
                    alterEgo: 'Peter Parker',
                    ownIt: true,
                    release: '0'
            ).save()
        }

        if (!Hero.findByHeroName('Iron-Man')) {
            new Hero(
                    heroName: 'Iron-Man',
                    alterEgo: 'Tony Stark',
                    ownIt: true,
                    release: '0'
            ).save()
        }

        if (!Hero.findByHeroName('Wasp')) {
            new Hero(
                    heroName: 'Wasp',
                    alterEgo: 'Nadia Van Dyne',
                    ownIt: true,
                    release: '2'
            ).save()
        }

        if (!Hero.findByHeroName('Captain America')) {
            new Hero(
                    heroName: 'Captain America',
                    alterEgo: 'Steve Rogers',
                    ownIt: true,
                    release: '1'
            ).save()
        }

        if (!Hero.findByHeroName('Black Widow')) {
            new Hero(
                    heroName: 'Black Widow',
                    alterEgo: 'Natasha Romanoff',
                    ownIt: true,
                    release: '1'
            ).save()
        }

        if (!ModularSet.findByEncounterName('Bomb Scare')) {
            new ModularSet(encounterName: 'Bomb Scare', abbreviation: 'Bmb Scr').save()
        }
        if (!ModularSet.findByEncounterName('Hydra Patrol')) {
            new ModularSet(encounterName: 'Hydra Patrol', abbreviation: 'Hydr Ptrl').save()
        }
        if (!ModularSet.findByEncounterName('Goblin Gear')) {
            new ModularSet(encounterName: 'Goblin Gear', abbreviation: 'Gbln Gr').save()
        }

        if (!Scenario.findByScenarioName('Rhino')) {
            new Scenario(scenarioName: 'Rhino').save()
        }
        if (!Scenario.findByScenarioName('Taskmaster')) {
            new Scenario(scenarioName: 'Taskmaster').save()
        }
        if (!Scenario.findByScenarioName('Red Skull')) {
            new Scenario(scenarioName: 'Red Skull').save()
        }
        if (!Scenario.findByScenarioName('Mutagen Formula')) {
            new Scenario(scenarioName: 'Mutagen Formula').save()
        }

//        Game gameOne = new Game(
//                gameName: 'Game One',
//                scenario: rhino,
//                difficultyLevel: Game.DifficultyLevel.Standard,
//                modularSet: bombScare,
//                outcome: Game.Outcome.Win,
//                funRating: 3,
//                difficultyRating: 4
//        ).save()
//
//        Game gameTwo = new Game(
//                gameName: 'Game Two',
//                scenario: taskmaster,
//                difficultyLevel: Game.DifficultyLevel.Standard,
//                modularSet: hydraPatrol,
//                outcome: Game.Outcome.Win,
//                funRating: 3,
//                difficultyRating: 2
//        ).save()
//
//        Game gameThree = new Game(
//                gameName: 'Game Three',
//                scenario: redSkull,
//                difficultyLevel: Game.DifficultyLevel.Standard,
//                modularSet: hydraPatrol,
//                outcome: Game.Outcome.Lose,
//                funRating: 4,
//                difficultyRating: 3
//        ).save()
//
//        Game gameFour = new Game(
//                gameName: 'Game Four',
//                scenario: mutagenFormula,
//                difficultyLevel: Game.DifficultyLevel.Expert,
//                modularSet: goblinGear,
//                outcome: Game.Outcome.Win,
//                funRating: 5,
//                difficultyRating: 3
//        ).save()
    }


    def destroy = {
    }
}