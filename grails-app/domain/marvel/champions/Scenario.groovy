package marvel.champions

class Scenario {
    String scenarioName

    static constraints = {
        scenarioName maxSize: 128, blank: false
    }

    String toString() {
        return "$scenarioName"
    }
}