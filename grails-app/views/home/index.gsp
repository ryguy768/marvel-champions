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
            <p class="highlight">MARVEL</p>
            <p><span>CHAMPIONS</span></p>
        </section>
    </div>

    <div id="content" role="main">
        <section class="row colset-2-its">
                    <!-- <p>MARVEL</p>
            <p>CHAMPIONS</p> -->



            <div id="controllers" role="navigation">
                <ul>
                    <li id="Game" class="controller">
                        <a href="/game/index" class="button">Go to game</a>
                    </li>
                    <li id="Hero" class="controller">
                        <a href="/hero/index" class="button">Go to hero</a>
                    </li>
                    <li id="ModulatSet" class="controller">
                        <a href="/modularSet/index" class="button">Go to modularSet</a>
                    </li>
                    <li id="Scenario" class="controller">
                        <a href="/scenario/index" class="button">Go to scenario</a>
                    </li>
                </ul>
            </div>

            
            <div id="contentArea"></div>

        </section>
    </div>

    <script>
        document.querySelectorAll('.button').forEach(button => {
            button.addEventListener('click', function(event) {
                event.preventDefault(); 
                const url = this.getAttribute('href'); 
                
                fetch(url) 
                    .then(response => {
                        if (!response.ok) throw new Error('Network response was not ok');
                        return response.text(); 
                    })
                    .then(data => {
                        document.getElementById('contentArea').innerHTML = data; 
                    })
                    .catch(error => {
                        console.error('There was a problem with the fetch operation:', error);
                        document.getElementById('contentArea').innerHTML = '<p>Error loading content. Please try again.</p>';
                    });
            });
        });
    </script>

</body>

</html>