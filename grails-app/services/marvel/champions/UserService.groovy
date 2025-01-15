package marvel.champions

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Transactional
@Service(User)
abstract class UserService {

    RoleService roleService
    UserRoleService userRoleService

    abstract User get(Long id)

    abstract List<User> list()

    abstract User save(User User)

    abstract User findAllByUsername(String username)

    User create(String username, String password, String passwordConfirm) {
        if (password != passwordConfirm) {
            log.error("Register Failed for user: $username. Passwords do not match.")
            throw new Exception("Passwords do not match.")
        }

        User user = new User(username: username, password: password)

        user.validate()
        if (user.hasErrors()) {
            def usernameError = user.errors.getFieldError('username')
            log.error("Register Failed for user: ${user.username}. Error: ${usernameError.defaultMessage}")
            throw new Exception("User validation failed. ${usernameError.defaultMessage}")
        }

        Role role = roleService.findByAuthority(Role.USER)
        log.error("Role: $role")
        UserRole userRole = new UserRole(user: user, role: role)
        log.error("UserRole: $userRole")
        log.error("userRoleService: $userRoleService")

        userRole.validate()
        if (userRole.hasErrors()) {
            log.error("Register Failed for user: ${user.username}. Error: ${userRole.errors}")
            throw new Exception("UserRole validation failed. ${userRole.errors}")
        }

        save(user)
        userRoleService.save(userRole)

        return user
    }
}
