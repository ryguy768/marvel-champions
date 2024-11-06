package marvel.champions

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HeroGameServiceSpec extends Specification {

    HeroGameService heroGameService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new HeroGame(...).save(flush: true, failOnError: true)
        //new HeroGame(...).save(flush: true, failOnError: true)
        //HeroGame heroGame = new HeroGame(...).save(flush: true, failOnError: true)
        //new HeroGame(...).save(flush: true, failOnError: true)
        //new HeroGame(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //heroGame.id
    }

    void "test get"() {
        setupData()

        expect:
        heroGameService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<HeroGame> heroGameList = heroGameService.list(max: 2, offset: 2)

        then:
        heroGameList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        heroGameService.count() == 5
    }

    void "test delete"() {
        Long heroGameId = setupData()

        expect:
        heroGameService.count() == 5

        when:
        heroGameService.delete(heroGameId)
        sessionFactory.currentSession.flush()

        then:
        heroGameService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        HeroGame heroGame = new HeroGame()
        heroGameService.save(heroGame)

        then:
        heroGame.id != null
    }
}
