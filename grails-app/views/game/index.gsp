<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-game" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                           default="Skip to content&hellip;"/></a>

<div class=" nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-game" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>
            <th class="sortable"><g:link action="index"
                                         params="[sort: 'gameName', max: 10, order: 'asc']">Game Name</g:link></th>
            <th class="sortable"><g:link action="index"
                                         params="[sort: 'heroGames', max: 10, order: 'asc']">Heroes</g:link></th>
            <th class="sortable"><g:link action="index"
                                         params="[sort: 'funRating', max: 10, order: 'asc']">Fun Rating</g:link></th>
            <th class="sortable"><g:link action="index"
                                         params="[sort: 'difficultyRating', max: 10, order: 'asc']">Difficulty Rating</g:link></th>
            <th class="sortable"><g:link action="index"
                                         params="[sort: 'outcome', max: 10, order: 'asc']">Outcome</g:link></th>
            <th class="sortable"><g:link action="index"
                                         params="[sort: 'scenario', max: 10, order: 'asc']">Scenario</g:link></th>
            <th class="sortable"><g:link action="index"
                                         params="[sort: 'difficultyLevel', max: 10, order: 'asc']">Difficulty Level</g:link></th>
            <th class="sortable"><g:link action="index"
                                         params="[sort: 'modularSet', max: 10, order: 'asc']">Modular Set</g:link></th>

        </tr>
        </thead>
        <tbody>
        <g:each in="${gameList}" var="game">
            <tr class="${(gameList.indexOf(game) % 2 == 0) ? 'even' : 'odd'}">
                <td><g:link action="show" id="${game.id}">${game.toString()}</g:link></td>
                <td>
                    <ul>
                        <g:each in="${game?.heroGames}" var="heroGame">
                            <a href="/hero/show/${heroGame?.hero?.id}">${heroGame?.hero?.heroName}</a> (${heroGame?.aspect})<br/>
                        </g:each>
                    </ul>
                </td>
                <td>${game.funRating}</td>
                <td>${game.difficultyRating}</td>
                <td>${game.outcome}</td>
                <td><g:link action="show" id="${game.scenario.id}">${game.scenario}</g:link></td>
                <td>${game.difficultyLevel}</td>
                <td><g:link action="show" id="${game.modularSet.id}">${game.modularSet}</g:link></td>
            </tr>
        </g:each>
        </tbody>
    </table>
    %{--    <f:table collection="${gameList}"/>--}%

    <div class="pagination">
        <g:paginate total="${gameCount ?: 0}"/>
    </div>
</div>
</body>
</html>