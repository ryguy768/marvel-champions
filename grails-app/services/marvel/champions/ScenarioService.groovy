package marvel.champions

import grails.gorm.services.Service

@Service(Scenario)
interface ScenarioService {

    Scenario save(String scenarioName)

    }
