package marvel.champions

class HeroGame {

    enum Aspect {
        Aggression, Justice, Leadership, Protection
    }

    User user
    Hero hero
    Game game
    Aspect aspect
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user: User, game: Game]

    static constraints = {
        user nullable: false
        game nullable: false
        hero nullable: true
        aspect nullable: false
    }

    String toString() {
        return 'Hero: ' + hero?.heroName + ', Aspect: ' + aspect
    }

}
