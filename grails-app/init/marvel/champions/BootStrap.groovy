/* groovylint-disable NglParseError, UnusedVariable */
package marvel.champions

import groovy.transform.CompileStatic

@CompileStatic
class BootStrap {

    GameService gameService
    HeroService heroService
    ModularSetService modularSetService
    ScenarioService scenarioService

    def init = { servletContext ->

        def adminRole = new Role(authority: Role.ADMIN).save()
        def userRole = new Role(authority: Role.USER).save()

        def adminUser = new User(username: 'admin', password: 'admin').save()
        def guestUser = new User(username: 'guest', password: 'guest').save()

        UserRole.create(adminUser, adminRole)
        UserRole.create(guestUser, userRole)


        if (!Hero.where { heroName == 'Spider-Man' }.find()) {
            new Hero(
                heroName: 'Spider-Man',
                alterEgo: 'Peter Parker',
                ownIt: true,
                release: '0'
            ).save()
        }

        if (!Hero.where { heroName == 'Iron-Man' }.find()) {
            new Hero(
                heroName: 'Iron-Man',
                alterEgo: 'Tony Stark',
                ownIt: true,
                release: '0'
            ).save()
        }

        if (!Hero.where { heroName == 'Wasp' }.find()) {
            new Hero(
                heroName: 'Wasp',
                alterEgo: 'Nadia Van Dyne',
                ownIt: true,
                release: '2'
            ).save()
        }

        if (!Hero.where { heroName == 'Captain America' }.find()) {
            new Hero(
                heroName: 'Captain America',
                alterEgo: 'Steve Rogers',
                ownIt: true,
                release: '1'
            ).save()
        }

        if (!Hero.where { heroName == 'Black Widow' }.find()) {
            new Hero(
                heroName: 'Black Widow',
                alterEgo: 'Natasha Romanoff',
                ownIt: true,
                release: '1'
            ).save()
        }

        if (!ModularSet.where { encounterName == 'Bomb Scare' }.find()) {
            new ModularSet(encounterName: 'Bomb Scare', abbreviation: 'Bmb Scr').save()
        }
        if (!ModularSet.where { encounterName == 'Hydra Patrol' }.find()) {
            new ModularSet(encounterName: 'Hydra Patrol', abbreviation: 'Hydr Ptrl').save()
        }
        if (!ModularSet.where { encounterName == 'Goblin Gear' }.find()) {
            new ModularSet(encounterName: 'Goblin Gear', abbreviation: 'Gbln Gr').save()
        }

        if (!Scenario.where { scenarioName == 'Rhino' }.find()) {
            new Scenario(scenarioName: 'Rhino').save()
        }
        if (!Scenario.where { scenarioName == 'Taskmaster' }.find()) {
            new Scenario(scenarioName: 'Taskmaster').save()
        }
        if (!Scenario.where { scenarioName == 'Red Skull' }.find()) {
            new Scenario(scenarioName: 'Red Skull').save()
        }
        if (!Scenario.where { scenarioName == 'Mutagen Formula' }.find()) {
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