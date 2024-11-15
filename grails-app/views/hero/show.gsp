<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'hero.label', default: 'Hero')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-hero" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-hero" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>

    <ol class="property-list hero">

        <li class="fieldcontain">
            <span id="heroName-label" class="property-label">Hero Name</span>

            <div class="property-value" aria-labelledby="heroName-label">${hero.heroName}</div>
        </li>

        <li class="fieldcontain">
            <span id="alterEgo-label" class="property-label">Alter Ego</span>

            <div class="property-value" aria-labelledby="alterEgo-label">${hero.alterEgo}</div>
        </li>

        <li class="fieldcontain">
            <span id="release-label" class="property-label">Release</span>

            <div class="property-value" aria-labelledby="release-label">${hero.release}</div>
        </li>

        <li class="fieldcontain">
            <span id="gameCount-label" class="property-label">Game Count</span>

            <div class="property-value" aria-labelledby="gameCount-label">${hero.heroGames.size()}</div>
        </li>

        <li class="fieldcontain">
            <span id="heroGames-label" class="property-label">Hero Games</span>
        </li>

        <li class="fieldcontain">
            <span id="funRating-label" class="property-label">Average Fun Rating</span>

            <div class="property-value" aria-labelledby="funRating-label">${hero.avgFunRating}</div>
        </li>

        <li class="fieldcontain">
            <span id="ownIt-label" class="property-label">Own It</span>

            <div class="property-value" aria-labelledby="ownIt-label">${hero.ownIt}</div>
        </li>
    </ol>

    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>

    <g:form resource="${this.hero}" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${this.hero}"><g:message code="default.button.edit.label" default="Edit"/></g:link>
            <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                   onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
