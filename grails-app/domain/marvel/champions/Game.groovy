package marvel.champions

class Game {
    String name
    Hero hero1
    Aspect aspect1
    Hero hero2 
    Aspect aspect2
    Hero hero3 
    Aspect aspect3
    Hero hero4
    Aspect aspect4
    Scenario scenario
    DifficultyLevel difficultyLevel
    ModularSet modularSet
    Outcome outcome
    int funRating
    int difficultyRating
    Date date

     enum DifficultyLevel {Standard, Expert};
     enum Aspect {Agression, Justice, Leadership, Protection}
     enum Outcome {Win, Lose}

    static constraints = {
        name maxSize: 100
        hero1 nullable: false
        aspect1 nullable: false
        hero2 nullable: true
        aspect2 nullable: true
        hero3 nullable: true
        aspect3 nullable: true
        hero4 nullable: true
        aspect4 nullable: true
        scenario nullable: false
        difficultyLevel nullable: false
        modularSet nullable: false
        outcome nullable: false
        funRating min: 0, max: 5
        difficultyRating min: 0, max: 5
        date nullable: false 
    }

    String getName() {
        return "$hero1 $scenario"
    }
    static belongsTo = [hero: Hero]
}

