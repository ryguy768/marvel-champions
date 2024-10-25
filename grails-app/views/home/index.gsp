<html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Home Page</title>
    <link rel="stylesheet" href="main.css">
</head>
<body>

<div id="svg" role="presentation">
    <section class="marvel-title-container">
       <p>MARVEL</p>

    </div>
    
</div>

<div id="content" role="main">
    <section class="row colset-2-its">
        <h1>Welcome to Grails</h1>

        <p>
            Congratulations, you have successfully started your first Grails application! At the moment
            this is the default page, feel free to modify it to either redirect to a controller or display
            whatever content you may choose. Below is a list of controllers that are currently deployed in
            this application, click on each to execute its default action:
        </p>

        <div id="controllers" role="navigation">
            <h2>Available Controllers:</h2>
            <ul>
                <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                    <li class="controller">
                        <g:link controller="${c.logicalPropertyName}" class="button">Go to ${c.logicalPropertyName}</g:link>
                    </li>
                </g:each>
            </ul>
        </div>
    </section>
</div>

</body>
</html>