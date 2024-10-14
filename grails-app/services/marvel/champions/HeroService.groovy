package marvel.champions

import grails.gorm.services.Service

@Service(Hero)
interface HeroService {

    Hero save(String heroName, String alterEgo, boolean ownIt, int gameCount,String release
    )
    }

