<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'heroGame.label', default: 'HeroGame')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<a href="#create-heroGame" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                 default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="create-heroGame" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.heroGame}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.heroGame}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.heroGame}" method="POST">
        <fieldset class="form">
            <div class="fieldcontain required">
                <label for="hero">Hero<span class="required-indicator">*</span></label>
                <g:select name="hero.id" from="${heroes}" optionKey="id" optionValue="heroName" required="" id="hero"/>
            </div>

            <div class="fieldcontain required">
                <label for="game">Game<span class="required-indicator">*</span></label>
                <g:select name="game.id" from="${games}" optionKey="id" optionValue="${{ it.toString() }}" required=""
                          id="game"/>
            </div>

            <div class="fieldcontain required">
                <label for="aspect">Aspect<span class="required-indicator">*</span></label>
                <select name="aspect" id="aspect">
                    <option value="Aggression">Aggression</option>
                    <option value="Justice">Justice</option>
                    <option value="Leadership">Leadership</option>
                    <option value="Protection">Protection</option>
                </select>
            </div>

        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save"
                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>