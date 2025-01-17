package marvel.champions

import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@Secured(['ROLE_ADMIN'])
class UserController {

    UserService userService

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        [users: userService.list()]
    }

    def create() {
        [user: new User()]
    }

    def save() {
        try {
            User user = new User(params)
            userService.save(user)
            flash.message = "User created successfully."
            redirect action: "index"
        } catch (ValidationException e) {
            flash.message = "Error creating user: ${e.message}"
            render view: "create", model: [user: params]
        }
    }

    def edit(Long id) {
        [user: userService.get(id)]
    }

    def update(Long id) {
        try {
            userService.update(id, params)
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