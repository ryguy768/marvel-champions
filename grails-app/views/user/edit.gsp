<div id="edit-user" class="content scaffold-edit" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.user}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.user}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.user}" method="PUT">
        <g:hiddenField name="version" value="${this.user?.version}"/>
        <fieldset class="form">
            <div class="fieldcontain ${hasErrors(bean: user, field: 'username', 'error')}">
                <label for="username">
                    <g:message code="user.username.label" default="Username"/>
                </label>
                <g:textField name="username" value="${user?.username}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'password', 'error')}">
                <label for="password">
                    <g:message code="user.password.label" default="Password"/>
                </label>
                <g:passwordField name="password" value="${user?.password}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'enabled', 'error')}">
                <label for="enabled">
                    <g:message code="user.enabled.label" default="Enabled"/>
                </label>
                <g:checkBox name="enabled" value="${user?.enabled}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'accountExpired', 'error')}">
                <label for="accountExpired">
                    <g:message code="user.accountExpired.label" default="Account Expired"/>
                </label>
                <g:checkBox name="accountExpired" value="${user?.accountExpired}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'accountLocked', 'error')}">
                <label for="accountLocked">x
                <g:message code="user.accountLocked.label" default="Account Locked"/>
                </label>
                <g:checkBox name="accountLocked" value="${user?.accountLocked}"/>
            </div>

            <div class="fieldcontain ${hasErrors(bean: user, field: 'passwordExpired', 'error')}">
                <label for="passwordExpired">
                    <g:message code="user.passwordExpired.label" default="Password Expired"/>
                </label>
                <g:checkBox name="passwordExpired" value="${user?.passwordExpired}"/>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <input class="save" type="submit"
                   value="${message(code: 'default.button.update.label', default: 'Update')}"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>