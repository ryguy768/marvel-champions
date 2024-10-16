package marvel.champions

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class HeroServiceSpec extends Specification implements ServiceUnitTest<HeroService>{

    def setup() {
    }

    def cleanup() {
    }

    void "test save hero"() {
        when:
        Hero hero = service.save(heroName: "Iron Man", alterEgo: "Tony Stark", ownIt: true, gameCount: 2, release: "3")
        
        then:
        hero.heroName == "Iron Man"
        hero.alterEgo == "Tony Stark"
        hero.ownIt == true
        hero.gameCount == 2
        hero.release == "3"
    }
}
