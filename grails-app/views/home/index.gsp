<html>
<html>

<head>
    <meta name="layout" content="main" />
    <title>Home Page</title>
    <link rel="stylesheet" href="main.css">
</head>

<body>

    <div id="svg" role="presentation">
        <section class="marvel-title-container">
            <p class="highlight">


                MARVEL</p>

            <p> <span>CHAMPIONS</span> </p>

    </div>

    </div>

    <div id="content" role="main">
        <section class="row colset-2-its">
            <!-- <p>MARVEL</p>
            <p>CHAMPIONS</p> -->


            <div id="controllers" role="navigation">
                <ul>
                    <g:each var="c" in="${grailsApplication.controllerClasses.sort { it.fullName } }">
                        <li class="controller">
                            <g:link controller="${c.logicalPropertyName}" class="button">Go to ${c.logicalPropertyName}
                            </g:link>
                        </li>
                    </g:each>
                </ul>
            </div>
        </section>
    </div>

</body>

</html>