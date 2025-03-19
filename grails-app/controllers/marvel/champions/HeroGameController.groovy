package marvel.champions

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.SpringSecurityService

class HeroGameController {

    static scaffold = HeroGame

    HeroGameService heroGameService
    SpringSecurityService springSecurityService
    GameService gameService

    static allowedMethods = [save: 'POST', update: 'PUT', delete: 'DELETE']

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        def currentUser = springSecurityService.currentUser
        def heroGames = HeroGame.findAllByUser(currentUser, params)
        respond heroGames, model: [heroGameCount: heroGames.size()]
    }

    def show(Long id) {
        respond heroGameService.get(id)
    }

    def create() {
        def currentUser = springSecurityService.currentUser
        def userGames = heroGameService.listGamesByUser(currentUser)
        respond new HeroGame(params), model: [
                userGames: userGames,
                heroes   : Hero.list(),
                games    : Game.findAllByUser(currentUser),
        ]
    }

    def save(HeroGame heroGame) {
        if (heroGame == null) {
            notFound()
            return
        }
        heroGame.user = springSecurityService.currentUser
        try {
            heroGameService.save(heroGame)
        } catch (ValidationException e) {
            respond heroGame.errors, view: 'create'
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
        def currentUser = springSecurityService.currentUser
        def userGames = heroGameService.listGamesByUser(currentUser)
        respond heroGameService.get(id), model: [userGames: userGames]
    }

    def update(HeroGame heroGame) {
        if (heroGame == null) {
            notFound()
            return
        }

        try {
            heroGameService.save(heroGame)
        } catch (ValidationException e) {
            respond heroGame.errors, view: 'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'heroGame.label', default: 'HeroGame'), heroGame.id])
                redirect heroGame
            }
            '*' { respond heroGame, [status: OK] }
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
                redirect action: 'index', method: 'GET'
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'heroGame.label', default: 'HeroGame'), params.id])
                redirect action: 'index', method: 'GET'
            }
            '*' { render status: NOT_FOUND }
        }
    }

    @Secured(["ROLE_ADMIN", "ROLE_USER"])
    def createAsync() {
        def gameId = params.gameId
        def heroId = params.heroId
        def aspect = params.aspect
        def currentUser = springSecurityService.currentUser

        if (!gameId || !heroId || !aspect) {
            render status: BAD_REQUEST, text: "Missing parameters"
            return
        }

        def gameInstance = gameService.findByTempId(gameId)
        def heroInstance = Hero.get(heroId)
        if (!gameInstance || !heroInstance) {
            render status: NOT_FOUND, text: "Game or Hero not found"
            return
        }

        def heroGame = new HeroGame(
                game: gameInstance,
                hero: heroInstance,
                aspect: aspect,
                user: currentUser
        )

        try {
            heroGameService.save(heroGame)
            render status: OK, text: "HeroGame created successfully"
        } catch (ValidationException e) {
            render status: UNPROCESSABLE_ENTITY, text: "Validation failed: ${e.message}"
        }
    }
}