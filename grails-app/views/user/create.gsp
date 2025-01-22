<html>
<head>
    <meta name="layout" content="main"/>
    <title>Create User</title>
</head>

<body>
<h3 style="font-size: x-large; margin-left: 720px; margin-right:1067px">Create User</h3>

<div id="form-box">
    <g:form controller="user" action="save">
        <div class="form-group">
            <label for="username"><g:message code="user.username.label" default="Username"/></label>
            <g:textField name="username" value="${user?.username}"/>
        </div>

        <div class="form-group">
            <label for="password"><g:message code="user.password.label" default="Password"/></label>
            <g:passwordField name="password"/>
        </div>

        <div class="form-group">
            <label for="passwordConfirm"><g:message code="user.passwordConfirm.label"
                                                    default="Confirm Password"/></label>
            <g:passwordField name="passwordConfirm"/>
        </div>

        <div class="form-group">
            <label for="enabled"><g:message code="user.enabled.label" default="Enabled"/></label>
            <g:checkBox name="enabled" value="${user?.enabled}"/>
        </div>

        <div class="form-group">
            <label for="accountExpired"><g:message code="user.accountExpired.label" default="Account Expired"/></label>
            <g:checkBox name="accountExpired" value="${user?.accountExpired}"/>
        </div>

        <div class="form-group">
            <label for="accountLocked"><g:message code="user.accountLocked.label" default="Account Locked"/></label>
            <g:checkBox name="accountLocked" value="${user?.accountLocked}"/>
        </div>

        <div class="form-group">
            <label for="passwordExpired"><g:message code="user.passwordExpired.label"
                                                    default="Password Expired"/></label>
            <g:checkBox name="passwordExpired" value="${user?.passwordExpired}"/>
        </div>

        <div class="form-group">
            <g:submitButton name="create" class="save"
                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </div>
    </g:form>
</div>
</body>
</html>