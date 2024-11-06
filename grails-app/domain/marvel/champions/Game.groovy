package marvel.champions

class Game {
    String name
    Scenario scenario
    DifficultyLevel difficultyLevel
    ModularSet modularSet
    Outcome outcome
    int funRating
    int difficultyRating
    Date date

     static hasMany = [heroGames : HeroGame]

     enum DifficultyLevel {Standard, Expert};
     enum Aspect {Agression, Justice, Leadership, Protection}
     enum Outcome {Win, Lose}

    static constraints = {
        name maxSize: 100
        scenario nullable: false
        difficultyLevel nullable: false
        modularSet nullable: false
        outcome nullable: false
        funRating min: 0, max: 5
        difficultyRating min: 0, max: 5
        date nullable: false 
    }

    String getName() {
        return "$scenario"
    }
}

