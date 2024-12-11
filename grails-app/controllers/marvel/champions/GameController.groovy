package marvel.champions

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*


@Secured(['ROLE_USER, ROLE_ADMIN'])
class GameController {

    GameService gameService
    ScenarioService scenarioService
    ModularSetService modularSetService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        def user = springSecurityService.currentUser
        log.debug("Current user: ${user.username}, Roles: ${user.authorities*.authority}")
        def games = user.authorities.any { it.authority == 'ROLE_ADMIN' } ? Game.list() : Game.findAllByUser(user)
        respond games
    }

    def show(Long id) {
        def game = gameService.get(id)
        if (game?.user?.id != springSecurityService.currentUser.id) {
            notFound()
            return
        }
        respond game
    }


    def create() {
        def scenarios = scenarioService.list()
        def modularSets = modularSetService.list()
        respond new Game(params), model: [scenarios: scenarios, modularSets: modularSets]
    }


    def save(Game game) {
        if (game == null) {
            notFound()
            return
        }

        game.user = springSecurityService.currentUser

        try {
            gameService.save(game)
        } catch (ValidationException e) {
            respond game.errors, view: 'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'game.label', default: 'Game'), game.id])
                redirect game
            }
            '*' { respond game, [status: CREATED] }
        }
    }

    def edit(Long id) {
        def game = gameService.get(id)
        def user = springSecurityService.currentUser
        if (game.user != user && !user.authorities.any { it.authority == 'ROLE_ADMIN' }) {
            notFound()
            return
        }
        respond game
    }

    def update(Game game) {
        if (game == null) {
            notFound()
            return
        }

        def user = springSecurityService.currentUser
        if (game.user != user && !user.authorities.any { it.authority == 'ROLE_ADMIN' }) {
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

    def delete(Long id) {

        if (id == null) {
            notFound()
            return
        }

        def game = gameService.get(id)
        def user = springSecurityService.currentUser
        if (game.user != user && !user.authorities.any { it.authority == 'ROLE_ADMIN' }) {
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
