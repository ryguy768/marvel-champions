<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Dashboard</title>
</head>

<body>
<div id="content" role="main">
    <section class="row colset-2-its">
        <sec:ifLoggedIn>
            <h1>Welcome ${username}</h1>

            <h2><g:link controller="logout">Logout</g:link></h2>
        </sec:ifLoggedIn>
    </section>
</div>
</body>
</html>