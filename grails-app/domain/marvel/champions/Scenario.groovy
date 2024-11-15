package marvel.champions

class Scenario {

    String scenarioName
    Date dateCreated
    Date lastUpdated

    static constraints = {
        scenarioName maxSize: 128, blank: false
    }

    String toString() {
        return "$scenarioName"
    }

}
