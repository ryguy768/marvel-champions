<html>
<head>
    <meta name="layout" content="${layoutUi}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
</head>

<body>
<h3><g:message code="default.create.label" args="[entityName]"/></h3>
<g:form controller="user" action="save">
    <div>
        <label for="username"><g:message code="user.username.label" default="Username"/></label>
        <g:textField name="username" value="${user?.username}"/>
    </div>

    <div>
        <label for="password"><g:message code="user.password.label" default="Password"/></label>
        <g:passwordField name="password"/>
    </div>

    <div>
        <label for="enabled"><g:message code="user.enabled.label" default="Enabled"/></label>
        <g:checkBox name="enabled" value="${user?.enabled}"/>
    </div>

    <div>
        <label for="accountExpired"><g:message code="user.accountExpired.label" default="Account Expired"/></label>
        <g:checkBox name="accountExpired" value="${user?.accountExpired}"/>
    </div>

    <div>
        <label for="accountLocked"><g:message code="user.accountLocked.label" default="Account Locked"/></label>
        <g:checkBox name="accountLocked" value="${user?.accountLocked}"/>
    </div>

    <div>
        <label for="passwordExpired"><g:message code="user.passwordExpired.label" default="Password Expired"/></label>
        <g:checkBox name="passwordExpired" value="${user?.passwordExpired}"/>
    </div>

    <div>
        <h4><g:message code="user.roles.label" default="Roles"/></h4>
        <g:each var="role" in="${authorityList}">
            <div>
                <g:checkBox name="roles" value="${role.authority}"/>
                <g:link controller="role" action="edit" id="${role.id}">${role.authority}</g:link>
            </div>
        </g:each>
    </div>

    <div>
        <g:submitButton name="create" class="save"
                        value="${message(code: 'default.button.create.label', default: 'Create')}"/>
    </div>
</g:form>
</body>
</html>