package marvel.champions

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Transactional
@Service(UserRole)
abstract class UserRoleService {

    abstract UserRole get(Long id)

    abstract UserRole save(UserRole UserRole)

}
