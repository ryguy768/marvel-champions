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
        name maxSize: 100
        hero1 nullable: true, inList: [] 
        aspect1 nullable: true, inList: ['Agression', 'Justice', 'Leadership', 'Protection']
        hero2 nullable: true, inList: [] 
        aspect2 nullable: true, inList: ['Agression', 'Justice', 'Leadership', 'Protection']
        hero3 nullable: true, inList: [] 
        aspect3 nullable: true, inList: ['Agression', 'Justice', 'Leadership', 'Protection']
        hero4 nullable: true, inList: [] 
        aspect4 nullable: true, inList: ['Agression', 'Justice', 'Leadership', 'Protection']
        scenario maxSize: 100
        difficultyLevel nullable: false, inList: ['Standard', 'Expert']
        modularSet nullable: true, maxSize: 255
        outcome nullable: false, inList: ['Win', 'Lose']
        funRating min: 0, max: 5
        difficultyRating min: 0, max: 5
        date maxSize: 100
    }
}

