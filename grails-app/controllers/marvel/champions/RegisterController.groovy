package marvel.champions

import grails.gorm.transactions.Transactional
import grails.plugin.springsecurity.annotation.Secured
import grails.validation.ValidationException

@Transactional
@Secured('permitAll')
class RegisterController {

    RoleService roleService
    UserService userService

    static allowedMethods = [register: "POST"]

    def index() {}

    def register() {
        User user = userService.create(params.username, params.password, params.repassword)
        flash.message = "You have registered successfully. Please login."
        redirect controller: "login", action: "auth"
    }
//
    /**
     * Exception handler for class Exception
     */

    def handleException(Exception e) {
        log.error("An error occurred: ${e.message}", e)
        flash.message = e.message
        redirect action: "index"
    }
}
