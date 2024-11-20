package marvel.champions

class Game {

    enum DifficultyLevel {

        Standard, Expert

    }

    enum Outcome {

        Win, Lose

    }

    String name // TODO: remove this field and calculate it from the other fields
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
        name maxSize: 128, blank: false
        funRating min: 0, max: 5
        difficultyRating min: 0, max: 5

    }


    // String getName() {
    //     return "$scenario"
    // }

    String toString() {
        return name
    }

}
