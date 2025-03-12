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
        def game = gameService.get(id)
        if (game) {
            def heroGames = HeroGame.findAllByGame(game)
            respond game, model: [heroGames: heroGames]
        } else {
            notFound()
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
        def scenarios = scenarioService.list()
        def modularSets = modularSetService.list()
        def heroes = Hero.list()
        respond new Game(params), model: [scenarios: scenarios, modularSets: modularSets, heroes: heroes]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save(Game game) {
        if (game == null) {
            notFound()
            return
        }

        game.user = springSecurityService.currentUser

        log.debug "Game params: ${params}"
        log.debug "Hero params: ${params.heroes}"

        try {
            Game.withTransaction { status ->
                if (!game.save(flush: true)) {
                    log.error "Game save errors: ${game.errors}"
                    respond game.errors, view: 'create'
                    return
                }

                if (params.heroes) {
                    params.heroes.each { index, heroData ->
                        log.debug "Processing hero data: ${heroData}"
                        def hero = Hero.get(heroData.id as Long)
                        if (hero) {
                            def heroGame = new HeroGame(
                                    hero: hero,
                                    game: game,
                                    aspect: heroData.aspect,
                                    user: game.user
                            )
                            if (!heroGame.save(flush: true)) {
                                log.error "HeroGame save errors: ${heroGame.errors}"
                            } else {
                                log.debug "Saved HeroGame: ${heroGame.id}"
                            }
                        }
                    }
                }
            }
            game.discard()
            game = Game.get(game.id)

            request.withFormat {
                form multipartForm {
                    flash.message = message(code: 'default.created.message', args: [message(code: 'game.label', default: 'Game'), game.id])
                    redirect game
                }
                '*' { respond game, [status: CREATED] }
            }

        } catch (ValidationException e) {
            log.error "Error saving game", e
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
