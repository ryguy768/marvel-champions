package marvel.champions

class HeroGame {

    enum Aspect {




        Aggression, Justice, Leadership, Protection

    }

    Hero hero
    Game game
    Aspect aspect
    Date dateCreated
    Date lastUpdated

    String toString() {
        return 'Hero: ' + hero?.heroName + ', Aspect: ' + aspect
    }

}
