package marvel.champions

class Scenario {

    String scenarioName
    Date dateCreated
    Date lastUpdated

    static constraints = {
        scenarioName maxSize: 128, nullable: false
    }

    String toString() {
        return "$scenarioName"
    }

}
