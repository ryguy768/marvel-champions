<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<a href="#create-game" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="create-game" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">

        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.game}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.game}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.game}" method="POST">
        <fieldset class="form">

            <div class="fieldcontain required">
                <label for="scenario">Scenario<span class="required-indicator">*</span></label>
                <g:select name="scenario.id" from="${scenarios}" optionKey="id" optionValue="scenarioName" required=""
                          id="scenario"/>
            </div>

            <div class="fieldcontain required">
                <label for="difficultyLevel">Difficulty Level<span class="required-indicator">*</span></label>
                <select name="difficultyLevel" id="difficultyLevel">
                    <option value="Standard">Standard</option>
                    <option value="Expert">Expert</option>
                </select>
            </div>

            <div class="fieldcontain required">
                <label for="modularSet">Modular Set<span class="required-indicator">*</span></label>
                <g:select name="modularSet.id" from="${modularSets}" optionKey="id" optionValue="encounterName"
                          required=""
                          id="modularSet"/>
            </div>

            <div class="fieldcontain required">
                <label for="outcome">Outcome<span class="required-indicator">*</span></label>
                <select name="outcome" id="outcome">
                    <option value="Win">Win</option>
                    <option value="Lose">Lose</option>
                </select>
            </div>

            <div class="fieldcontain required">
                <label for="funRating">Fun Rating<span class="required-indicator">*</span></label>
                <input type="number" name="funRating" min="0" max="5" required="" id="funRating"/>
            </div>

            <div class="fieldcontain required">
                <label for="difficultyRating">Difficulty Rating<span class="required-indicator">*</span></label>
                <input type="number" name="difficultyRating" min="0" max="5" required="" id="difficultyRating"/>
            </div>



            %{--            <f:all bean="game"/>--}%
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save"
                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>