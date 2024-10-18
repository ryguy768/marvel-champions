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
        aspect1 inList: ['Agression', 'Justice', 'Leadership', 'Protection']
        hero2 inList: []
        aspect2 inList: ['Agression', 'Justice', 'Leadership', 'Protection']
        hero3 inList: []
        aspect3 inList: ['Agression', 'Justice', 'Leadership', 'Protection']
        hero4 inList: []
        aspect4 inList: ['Agression', 'Justice', 'Leadership', 'Protection']
        scenario Maxsize: 100
        difficultyLevel inList: ['Standard', 'Expert'] 
        modularSet inList: []
        outcome inList: ['Win', 'Lose']
        funRating max: 5
        difficultyRating max: 5
        date Maxsize: 100


    }
}
