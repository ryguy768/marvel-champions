package marvel.champions

import grails.gorm.transactions.Transactional

@Transactional
class HeroServiceImpl implements HeroService {
    Hero get(Long id) {
        Hero.get(id)
    }

    Hero save(String heroName, String alterEgo, boolean ownIt, int gameCount, String release) {
        Hero hero = new Hero(heroName: heroName, alterEgo: alterEgo, ownIt: ownIt, gameCount: gameCount, release: release)
        if (hero.save()) {
            return hero
        } else {
            return null
        }
    }

    int countGames(Long id) {
        
        Hero currentHero = Hero.get(id)
        
        return Game.countByHero1(currentHero) 
    }
}
