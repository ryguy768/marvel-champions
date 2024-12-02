package marvel.champions

import grails.gorm.services.Service

@Service(ModularSet)
interface ModularSetService {

    ModularSet save(String encounterName, String abbreviation)

    ModularSet save(ModularSet modularSet)

    List<ModularSet> list()

}

