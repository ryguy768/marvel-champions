package marvel.champions

class Hero {

    String heroName
    String alterEgo
    boolean ownIt
    String release //TODO: change this to a domain object

    static hasMany = [heroGames: HeroGame]

    static constraints = {
        heroName maxSize: 128, blank: false
        alterEgo maxSize: 128, blank: false
        release maxSize: 128, blank: false
    }

    String toString() {
        return "$heroName ($alterEgo)"
    }

    Integer getAvgFunRating() {
        if (!heroGames) return null
        List<Integer> funRatings = heroGames*.game*.funRating
        return funRatings.sum() / funRatings.size()
    }

}
