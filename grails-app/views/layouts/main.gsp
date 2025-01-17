<!doctype html>
<html lang="en" class="no-js">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
    <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>
    <asset:javascript src="application.js"/>

    <g:layoutHead/>
</head>

<body>
<g:if test="${controllerName == 'dashboard' && actionName == 'index'}">
    <nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
        <a class="navbar-brand" href="/#">
            <asset:image src="logo.png" alt="Shield Logo"/>
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent"
                aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
            <ul class="nav navbar-nav ml-left">
            %{--                <g:pageProperty name="page.nav" default="Default Navigation Content"/>--}%
                <sec:ifLoggedIn>
                    <li class="nav-item">
                        <button id="gameButton" class="btn btn-primary">Go to game</button>
                    </li>
                    <sec:ifAllGranted roles="ROLE_ADMIN">
                        <li class="nav-item">
                            <button id="userButton" class="btn btn-primary">Manage Users</button>
                        </li>
                    </sec:ifAllGranted>
                </sec:ifLoggedIn>
            </ul>
        </div>
    </nav>
</g:if>
<g:layoutBody/>

<div class="footer row" role="contentinfo"></div>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>

</html>