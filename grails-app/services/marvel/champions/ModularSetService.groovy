package marvel.champions

import grails.gorm.services.Service

@Service(ModularSet)
interface ModularSetService {

    ModularSet save(String encounterName, String abbreviation)

    }

