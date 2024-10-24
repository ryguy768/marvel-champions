package marvel.champions

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HeroServiceSpec extends Specification {

    HeroService heroService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Hero(...).save(flush: true, failOnError: true)
        //new Hero(...).save(flush: true, failOnError: true)
        //Hero hero = new Hero(...).save(flush: true, failOnError: true)
        //new Hero(...).save(flush: true, failOnError: true)
        //new Hero(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //hero.id
    }

    void "test get"() {
        setupData()

        expect:
        heroService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Hero> heroList = heroService.list(max: 2, offset: 2)

        then:
        heroList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        heroService.count() == 5
    }

    void "test delete"() {
        Long heroId = setupData()

        expect:
        heroService.count() == 5

        when:
        heroService.delete(heroId)
        sessionFactory.currentSession.flush()

        then:
        heroService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Hero hero = new Hero()
        heroService.save(hero)

        then:
        hero.id != null
    }
}
