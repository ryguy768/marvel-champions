package marvel.champions

class Game {

    enum DifficultyLevel {

        Standard, Expert

    }

    enum Outcome {

        Win, Lose

    }

    String gameName // TODO: remove this field and calculate it from the other fields
    Scenario scenario
    DifficultyLevel difficultyLevel
    ModularSet modularSet
    Outcome outcome
    int funRating
    int difficultyRating
    Date dateCreated
    Date lastUpdated


    static hasMany = [heroGames: HeroGame]

    static constraints = {
        gameName nullable: false, blank: false
        funRating min: 0, max: 5
        difficultyRating min: 0, max: 5

    }

//    @Override
    String toString() {
        def heroNames = heroGames?.hero?.heroName?.join(", ")
        return "${heroNames} vs ${scenario}"
    }


}
