package marvel.champions

class ModularSet {

    String encounterName
    String abbreviation

    static constraints = {
        encounterName maxSize: 128, blank: false
        abbreviation maxSize: 128, blank: false
    }

    String toString() {
        return "$encounterName ($abbreviation)"
    }

}
