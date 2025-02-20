// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.logout.postOnly = false

grails.plugin.springsecurity.userLookup.userDomainClassName = 'marvel.champions.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'marvel.champions.UserRole'
grails.plugin.springsecurity.authority.className = 'marvel.champions.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/create.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/heroGame/**', access: ['ROLE_USER', 'ROLE_ADMIN']],
        [pattern: '/user/**', access: ['ROLE_ADMIN']],
        [pattern: '/**', access: ['ROLE_ADMIN']]
]

grails.plugin.springsecurity.successHandler.defaultTargetUrl = '/dashboard'

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]

