package marvel.champions

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Transactional
@Service(Hero)
abstract class HeroService {

    abstract Hero get(Long id)

    abstract List<Hero> list()

    abstract Hero save(Hero hero)

}
