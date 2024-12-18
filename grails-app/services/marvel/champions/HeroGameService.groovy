package marvel.champions

import grails.gorm.services.Service

@Service(HeroGame)
interface HeroGameService {

    HeroGame get(Serializable id)

    abstract List<Game> findAllByUser(User user, Map params)

    Long count()

    void delete(Serializable id)

    HeroGame save(Game game, Hero hero, HeroGame.Aspect aspect)

    HeroGame save(HeroGame heroGame)

}
