package marvel.champions

import grails.gorm.services.Service

@Service(HeroGame)
abstract class HeroGameService {

    abstract HeroGame get(Serializable id)

    abstract List<HeroGame> listGamesByUser(User user)

    abstract Long count()

    abstract void delete(Serializable id)

    abstract HeroGame save(Game game, Hero hero, HeroGame.Aspect aspect)

    abstract HeroGame save(HeroGame heroGame)

    List<HeroGame> findAllByUser(User user) {
        HeroGame.findAllByUser(user)
    }


}
