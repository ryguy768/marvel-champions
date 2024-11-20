<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}"/>
    <title>
    <g:message code="default.show.label" args="[entityName]"/>
    </title>
</head>

<body>
<a href="#show-game" class="skip" tabindex="-1">
    <g:message code="default.link.skip.label" default="Skip to content&hellip;"/>
</a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}">
            <g:message code="default.home.label"/>
        </a></li>
        <li>
            <g:link class="list" action="index">
                <g:message code="default.list.label" args="[entityName]"/>
            </g:link>
        </li>
        <li>
            <g:link class="create" action="create">
                <g:message code="default.new.label" args="[entityName]"/>
            </g:link>
        </li>
    </ul>
</div>

<div id="show-game" class="content scaffold-show" role="main">
    <h1>
        <g:message code="default.show.label" args="[entityName]"/>
    </h1>
    <ol class="property-list game">
        <li class="fieldcontain">
            <span id="name-label" class="property-label">Game Name</span>

            <div class="property-value" aria-labelledby="name-label">${game.name}</div>
        </li>
        <li class="fieldcontain">
            <span id="heroGames-label" class="property-label">Hero Games</span>

            <div class="property-value" aria-labelledby="heroGames-label">
                <g:each in="${game?.heroGames}" var="heroGame">
                    <a href="/heroGame/show/${heroGame?.id}">${heroGame}</a><br/>
                </g:each>
            </div>
        </li>
        <li class="fieldcontain">
            <span id="scenario-label" class="property-label">Scenario</span>

            <div class="property-value" aria-labelledby="name-label">${game.scenario}</div>
        </li>
        <li class="fieldcontain">
            <span id="difficultyLevel-label" class="property-label">Difficulty Level</span>

            <div class="property-value" aria-labelledby="name-label">${game.difficultyLevel}</div>
        </li>
        <li class="fieldcontain">
            <span id="modularSet-label" class="property-label">Modular Set</span>

            <div class="property-value" aria-labelledby="name-label">${game.modularSet}</div>
        </li>
        <li class="fieldcontain">
            <span id="outcome-label" class="property-label">Outcome</span>

            <div class="property-value" aria-labelledby="name-label">${game.outcome}</div>
        </li>
        <li class="fieldcontain">
            <span id="funRating-label" class="property-label">Fun Rating</span>

            <div class="property-value" aria-labelledby="name-label">${game.funRating}</div>
        </li>
        <li class="fieldcontain">
            <span id="difficultyRating-label" class="property-label">Difficulty Rating</span>

            <div class="property-value" aria-labelledby="name-label">${game.difficultyRating}</div>
        </li>
        <li class="fieldcontain">
            <span id="dateCreated-label" class="property-label">Date Created</span>

            <div class="property-value" aria-labelledby="dateCreated-label"><g:formatDate
                    format="yyyy-MM-dd 'at' HH:mm:ss z" date="${game.dateCreated}"/></div>
        </li>

        <li class="fieldcontain">
            <span id="lastUpdated-label" class="property-label">Last Updated</span>

            <div class="property-value" aria-labelledby="lastUpdated-label"><g:formatDate
                    format="yyyy-MM-dd 'at' HH:mm:ss z" date="${game.lastUpdated}"/></div>
        </li>

    </ol>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
%{--        <f:display bean="game"/>--}%
    <g:form resource="${this.game}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${this.game}">
                <g:message code="default.button.edit.label" default="Edit"/>
            </g:link>
            <input class="delete" type="submit"
                   value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                   onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>

</html>