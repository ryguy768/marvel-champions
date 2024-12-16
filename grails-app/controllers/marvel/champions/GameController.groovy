package marvel.champions

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class GameController {

    GameService gameService
    ScenarioService scenarioService
    ModularSetService modularSetService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond gameService.list(params), model: [gameCount: gameService.count()]
    }

    def show(Long id) {
        respond gameService.get(id)
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
        respond gameService.get(id)
    }

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
