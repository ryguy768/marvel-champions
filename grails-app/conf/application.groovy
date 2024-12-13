// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.logout.postOnly = true
grails.plugin.springsecurity.logout.url = '/login/auth'
grails.plugin.springsecurity.ui.register.postRegisterUrl = '/login/auth'

grails.plugin.springsecurity.userLookup.userDomainClassName = 'marvel.champions.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'marvel.champions.UserRole'
grails.plugin.springsecurity.authority.className = 'marvel.champions.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/login/**', access: ['permitAll']],
        [pattern: '/logout', access: ['isAuthenticated()']],
        [pattern: '/game/index', access: ['isAuthenticated()']],
        [pattern: '/game/create', access: ['isAuthenticated()']],
        [pattern: '/game/save', access: ['isAuthenticated()']],
        [pattern: '/**/show/**', access: ['isAuthenticated()']],
        [pattern: '/**', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]


