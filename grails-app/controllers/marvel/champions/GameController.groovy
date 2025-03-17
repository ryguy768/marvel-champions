package marvel.champions

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService

class GameController {

    GameService gameService
    ScenarioService scenarioService
    ModularSetService modularSetService
    SpringSecurityService springSecurityService
    HeroService heroService
    HeroGameService heroGameService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def currentUser = springSecurityService.currentUser
        def games = Game.findAllByUser(currentUser, params)
        respond games, model: [gameCount: games.size()]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def show(Long id) {
        respond gameService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
        def scenarios = scenarioService.list()
        def modularSets = modularSetService.list()
        def heroes = heroService.list()
        respond new Game(params), model: [scenarios: scenarios, modularSets: modularSets, heroes: heroes]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save(Game game) {
        def currentUser = springSecurityService.currentUser
        game.user = currentUser
        if (game == null) {
            notFound()
            return
        }

        try {
            gameService.save(game)

            params.heroes.each { heroParams ->
                def hero = heroService.get(heroParams.id as Long)
                if (hero) {
                    def heroGame = new HeroGame(game: game, hero: hero, aspect: heroParams.aspect)
                    heroGameService.save(heroGame)
                }
            }

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'game.label', default: 'Game'), game.id])
                    redirect(action: "show", id: game.id)
                }
                '*' { respond game, [status: CREATED] }
            }
        } catch (ValidationException e) {
            respond game.errors, view: 'create'
            return
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def edit(Long id) {
        respond gameService.get(id)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def update(Game game) {
        if (game == null) {
            notFound()
            return
        }

        try {
            gameService.save(game)
        } catch (ValidationException e) {
            respond game.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'game.label', default: 'Game'), game.id])
                redirect game
            }
            '*' { respond game, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        gameService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'game.label', default: 'Game'), id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'game.label', default: 'Game'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}