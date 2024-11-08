package marvel.champions

import grails.gorm.services.Service

@Service(HeroGame)
interface HeroGameService {

    HeroGame get(Serializable id)

    List<HeroGame> list(Map args)

    Long count()

    void delete(Serializable id)

    HeroGame save(HeroGame heroGame)

}
