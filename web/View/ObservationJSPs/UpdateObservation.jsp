<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Update observation</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../../assets/css/main.css" />
    <noscript><link rel="stylesheet" href="../../assets/css/noscript.css" /></noscript>
</head>
    <body class="is-preload">

    <!-- Wrapper-->
    <div id="wrapper">

        <!-- Nav -->
        <nav id="nav">
            <a href="#update" class="icon fa-pencil-square-o"><span>Updating</span></a>
        </nav>

        <!-- Main -->
        <div id="main">

            <!-- Update -->
            <article id="update" class="panel">
                <header>
                    <h2>Update observation</h2>
                </header>
                <form action="/ObserverController" method="post">

                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="observationId" value="${observation.observationId}">

                    <div>
                        <div class="row">
                            <div class="col-6 col-12-medium">
                                <input disabled type="text" name="observationId" placeholder="Observation id" value="${observation.observationId}" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input type="text" name="latitude" placeholder="Latitude"  value="${observation.latitude}"/>
                            </div>
                            <div class="col-12">
                                <input type="text" name="longitud" placeholder="Longitude" value="${observation.longitude}"/>
                            </div>
                            <div class="col-6 col-12-medium">
                                <input type="date" name="date" placeholder="Date" value="${observation.date}" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input type="text" name="specie" placeholder="Specie name" value="${observation.specieName}"/>
                            </div>
                            <div class="col-12">
                                <input type="text" name="username" placeholder="User name" value="${observation.userName}"/>
                            </div>
                            <div class="col-12">
                                <input type="text" name="imageURL" placeholder="Image url" value="${observation.imageURL}"/>
                            </div>
                            <div class="col-12">
                                <input type="submit" value="Finish" />
                            </div>
                        </div>
                    </div>
                </form>
            </article>

        </div>

        <!-- Footer -->
        <div id="footer">
            <ul class="copyright">
                <li>&copy; Untitled.</li><li>Design: <a href="http://html5up.net">HTML5 UP</a></li>
            </ul>
        </div>

    </div>

    <!-- Scripts -->
    <script src="../../assets/js/jquery.min.js"></script>
    <script src="../../assets/js/browser.min.js"></script>
    <script src="../../assets/js/breakpoints.min.js"></script>
    <script src="../../assets/js/util.js"></script>
    <script src="../../assets/js/main.js"></script>

    </body>
</html>

