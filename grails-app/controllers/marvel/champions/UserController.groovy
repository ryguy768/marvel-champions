package marvel.champions

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException
import grails.gorm.transactions.Transactional

@Secured(['ROLE_ADMIN'])
class UserController {

    UserService userService
    GameService gameService

    static allowedMethods = [save: "POST", update: ["POST", "PUT"], delete: "POST"]

    def index() {
        [users: userService.list()]
    }

    def create() {
        [user: new User()]
    }

    def save() {
        try {
            userService.create(params.username, params.password, params.passwordConfirm)
            flash.message = "User created successfully."
            redirect action: "index"
        } catch (ValidationException e) {
            flash.message = "Error creating user: ${e.message}"
            render view: "create", model: [user: params]
        }
    }

    def edit(Long id) {
        def user = userService.get(id)
        def games = gameService.findAllByUser(user)
        def roles = user.getAuthorities()
        [user: user, games: games, roles: roles, allRoles: Role.list()]
    }

    @Transactional
    def update(Long id) {
        try {
            User user = userService.get(id)
            userService.update(id, params)

            UserRole.removeAll(user)
            params.roles.each { roleName ->
                Role role = Role.findByAuthority(roleName)
                UserRole.create(user, role, true)
            }

            flash.message = "User updated successfully."
            redirect action: "index"
        } catch (ValidationException e) {
            flash.message = "Error updating user: ${e.message}"
            render view: "edit", model: [user: params]
        }
    }

    def delete(Long id) {
        userService.delete(id)
        flash.message = "User deleted successfully."
        redirect action: "index"
    }

}