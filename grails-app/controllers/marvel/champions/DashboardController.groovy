package marvel.champions

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class DashboardController {

    SpringSecurityService springSecurityService

    def index() {
        def user = springSecurityService.currentUser
        if (user) {
            [username: user.username]
        } else {
            redirect(controller: 'login', action: 'auth')
        }
    }
}
