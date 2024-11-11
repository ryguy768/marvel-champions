package marvel.champions

class HeroGame {

    enum Aspect { Agression, Justice, Leadership, Protection }

    Hero hero
    Game game
    Aspect aspect

    static constraints = {
    }

    String toString() {
        return 'Hero: ' + hero?.heroName + ', Aspect: ' + aspect
    }

}
