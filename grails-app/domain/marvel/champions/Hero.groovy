package marvel.champions

class Hero {
    
    String heroName
    String alterEgo
    boolean ownIt
    int gameCount
    String release
    Long id
    
    static constraints = {
        heroName maxSize: 100
        alterEgo maxSize: 100
        release maxSize: 100
        gameCount min: 0
    }
    String toString (){
        return "$heroName ($alterEgo)"
    }
}
