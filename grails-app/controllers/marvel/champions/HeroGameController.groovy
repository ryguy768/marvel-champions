package marvel.champions

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class HeroGameController {

    static scaffold = HeroGame

    HeroGameService heroGameService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond heroGameService.list(params), model:[heroGameCount: heroGameService.count()]
    }

    def show(Long id) {
        respond heroGameService.get(id)
    }

    def create() {
        respond new HeroGame(params)
    }

    def save(HeroGame heroGame) {
        if (heroGame == null) {
            notFound()
            return
        }

        try {
            heroGameService.save(heroGame)
        } catch (ValidationException e) {
            respond heroGame.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'heroGame.label', default: 'HeroGame'), heroGame.id])
                redirect heroGame
            }
            '*' { respond heroGame, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond heroGameService.get(id)
    }

    def update(HeroGame heroGame) {
        if (heroGame == null) {
            notFound()
            return
        }

        try {
            heroGameService.save(heroGame)
        } catch (ValidationException e) {
            respond heroGame.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'heroGame.label', default: 'HeroGame'), heroGame.id])
                redirect heroGame
            }
            '*'{ respond heroGame, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        heroGameService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'heroGame.label', default: 'HeroGame'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'heroGame.label', default: 'HeroGame'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
