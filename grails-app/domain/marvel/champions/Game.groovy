package marvel.champions

class Game {

    enum DifficultyLevel { Standard, Expert };
    enum Aspect { Agression, Justice, Leadership, Protection }
    enum Outcome { Win, Lose }

    String name
    Scenario scenario
    DifficultyLevel difficultyLevel
    ModularSet modularSet
    Outcome outcome
    int funRating
    int difficultyRating
    // Date date // TODO lookup dateCreated and lastUpdated
    Date dateCreated
    Date lastUpdated

    static hasMany = [heroGames : HeroGame]

    static constraints = {
        name maxSize: 100
        scenario nullable: false
        difficultyLevel nullable: false
        modularSet nullable: false
        outcome nullable: false
        funRating min: 0, max: 5
        difficultyRating min: 0, max: 5
    }

    // String getName() {
    //     return "$scenario"
    // }

    String toString() {
        return name
    }
    def beforeInsert() {
        dateCreated = new Date()
    }

    def beforeUpdate() {
        lastUpdated = new Date()
    }

}
