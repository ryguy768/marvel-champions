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
        Hero spiderMan = new Hero(
                heroName: 'Spider-Man',
                alterEgo: 'Peter Parker',
                ownIt: true,
                release: '0'
        ).save()

        Hero ironMan = new Hero(
                heroName: 'Iron-Man',
                alterEgo: 'Tony Stark',
                ownIt: true,
                release: '0'
        ).save()

        Hero wasp = new Hero(
                heroName: 'Wasp',
                alterEgo: 'Nadia Van Dyne',
                ownIt: true,
                release: '2'
        ).save()

        Hero captainAmerica = new Hero(
                heroName: 'Captain America',
                altereEgo: 'Steve Rogers',
                ownIt: true,
                release: '1'
        ).save()

        Hero blackWidow = new Hero(
                heroName: 'Black Widow',
                alterEgo: 'Natasha Romanoff',
                ownIt: true,
                release: '1'
        ).save()

        ModularSet bombScare = new ModularSet(encounterName: 'Bomb Scare', abbreviation: 'Bmb Scr').save()
        ModularSet hydraPatrol = new ModularSet(encounterName: 'Hydra Patrol', abbreviation: 'Hydr Ptrl').save()
        ModularSet goblinGear = new ModularSet(encounterName: 'Goblin Gear', abbreviation: 'Gbln Gr').save()

        Scenario rhino = new Scenario(scenarioName: 'Rhino').save()
        Scenario taskmaster = new Scenario(scenarioName: 'Taskmaster').save()
        Scenario redSkull = new Scenario(scenarioName: 'Red Skull').save()
        Scenario mutagenFormula = new Scenario(scenarioName: 'Mutagen Formula').save()

        Game gameOne = new Game(
                gameName: 'Game One',
                scenario: rhino,
                difficultyLevel: Game.DifficultyLevel.Standard,
                modularSet: bombScare,
                outcome: Game.Outcome.Win,
                funRating: 3,
                difficultyRating: 4

        ).save()

        Game gameTwo = new Game(
                gameName: 'Game Two',
                scenario: taskmaster,
                difficultyLevel: Game.DifficultyLevel.Standard,
                modularSet: hydraPatrol,
                outcome: Game.Outcome.Win,
                funRating: 3,
                difficultyRating: 2
        ).save()

        Game gameThree = new Game(
                gameName: 'Game Three',
                scenario: redSkull,
                difficultyLevel: Game.DifficultyLevel.Standard,
                modularSet: hydraPatrol,
                outcome: Game.Outcome.Lose,
                funRating: 4,
                difficultyRating: 3
        ).save()

        Game gameFour = new Game(
                gameName: 'Game Four',
                scenario: mutagenFormula,
                difficultyLevel: Game.DifficultyLevel.Expert,
                modularSet: goblinGear,
                outcome: Game.Outcome.Win,
                funRating: 5,
                difficultyRating: 3
        ).save()
    }

    def destroy = {
    }

}
