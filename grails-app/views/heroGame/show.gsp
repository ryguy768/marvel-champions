<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'heroGame.label', default: 'HeroGame')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-heroGame" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-heroGame" class="content scaffold-show" role="main">

    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list heroGame">
        <li class="fieldcontain">
            <span id="heroGame-label" class="property-label">Game</span>

            <div class="property-value" aria-labelledby="heroGame-label">
                <a href="${createLink(controller: 'game', action: 'show', id: heroGame.game.id)}">${heroGame.game}</a>
            </div>
        </li>
        <li class="fieldcontain">
            <span id="hero-label" class="property-label">Hero</span>

            <div class="property-value" aria-labelledby="hero-label">
                <a href="${createLink(controller: 'hero', action: 'show', id: heroGame.hero.id)}">${heroGame.hero}</a>
            </div>
        </li>
        <li class="fieldcontain">
            <span id="aspect-label" class="property-label">Aspect</span>

            <div class="property-value" aria-labelledby="aspect-label">${heroGame.aspect}</div>
        </li>
        %{--    <li class="fieldcontain">--}%
        %{--        <span id="user-label" class="property-label">User</span>--}%

        %{--        <div class="property-value" aria-labelledby="user-label"><a--}%
        %{--                href="/user/show/${heroGame.user.id}">${heroGame.user}</a></div>--}%
        %{--    </li>--}%
    </ol>
    <g:form resource="${this.heroGame}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${this.heroGame}"><g:message code="default.button.edit.label"
                                                                                      default="Edit"/></g:link>
            <input class="delete" type="submit"
                   value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                   onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
