package marvel.champions

import grails.gorm.services.Service
import grails.gorm.transactions.Transactional

@Transactional
@Service(Role)
abstract class RoleService {

    abstract Role get(Long id)

    abstract Role save(Role Role)

    abstract Role findByAuthority(String authority)

}
