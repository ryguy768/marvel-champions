package marvel.champions

class HeroGame {

    Hero hero
    Game game

    static constraints = {
    }

    String toString() {
        return hero?.heroName
    }

}
