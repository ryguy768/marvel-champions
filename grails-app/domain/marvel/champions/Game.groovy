package marvel.champions

class Game {

    String name 
    Hero hero1
    String aspect1
    Hero hero2 
    String aspect2
    Hero hero3 
    String aspect3
    Hero hero4
    String aspect4
    String scenario
    String difficultyLevel
    String modularSet
    String outcome
    int funRating
    int difficultyRating
    String date


    static constraints = {
        name Maxsize: 100
        hero1 inList: []
    }
}
