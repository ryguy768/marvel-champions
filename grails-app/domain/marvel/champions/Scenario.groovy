package marvel.champions

class Scenario {
    String scenarioName


    static constraints = {
        scenarioName maxSize: 100
    }
    String toString(){
        return "$scenarioName"
    }
}