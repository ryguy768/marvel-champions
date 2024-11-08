package marvel.champions

class ModularSet {

    String encounterName
    String abbreviation

    static constraints = {
        encounterName maxSize: 100
        abbreviation maxSize: 100
    }
    String toString() {
        return "$encounterName ($abbreviation)"
    }

}
