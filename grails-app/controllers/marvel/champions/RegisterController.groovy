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
        render view: "index"
    }

    def registerOld() {
        if (!params.password.equals(params.repassword)) {
            flash.message = "Password and Re-Password not match"
            redirect action: "index"
            return
        } else {
            try {
                def user = User.findByUsername(params.username) ?: new User(username: params.username, password: params.password).save()
                def role = Role.get(params.role.id)
                if (user && role) {
                    UserRole.create user, role

                    UserRole.withSession {
                        it.flush()
                        it.clear()
                    }

                    flash.message = "You have registered successfully. Please login."
                    redirect controller: "login", action: "auth"
                } else {
                    flash.message = "Register failed"
                    render view: "index"
                    return
                }
            } catch (ValidationException e) {
                flash.message = "Register Failed"
                redirect action: "index"
                return
            }
        }
    }

    /**
     * Exception handler for class Exception
     */

    def handleException(Exception e) {
        log.error("An error occurred: ${e.message}", e)
        flash.message = e.message
        redirect action: "index"
    }
}
