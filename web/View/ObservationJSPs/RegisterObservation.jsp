<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>New observation</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="../../assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../assets/css/main.css" />
    <noscript><link rel="stylesheet" href="../../assets/css/noscript.css" /></noscript>
</head>
    <body class="is-preload">

    <!-- Wrapper-->
    <div id="wrapper">

        <!-- Nav -->
        <nav id="nav">
            <a href="#register" class="icon fa-search-plus"><span>Register</span></a>
        </nav>

        <!-- Main -->
        <div id="main">

            <!-- Register -->
            <article id="register" class="panel">
                <header>
                    <h2>New observation</h2>
                </header>
                <form action="ObserverController" method="get">

                    <input type="hidden" name="action" value="insert">
                    <input type="hidden" name="username" value="${CurrentUser}">

                    <div>
                        <div class="row">
                            <div class="col-6 col-12-medium">
                                <input required type="text" name="latitude" placeholder="Latitude" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input required type="text" name="longitude" placeholder="Longitude" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input required type="date" name="date"/>
                            </div>
                            <div class="col-6 col-12-medium">

                                <input required type="text" name="specie" list="species" placeholder="Specie Name">

                                <datalist id="species">

                                    <c:forEach var="Specie" items="${Species}">
                                        <option>${Specie}</option>
                                    </c:forEach>

                                </datalist>

                            </div>
                            <div class="col-6 col-12-medium">
                                <input disabled type="text" name="username" value="${CurrentUser}" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input required type="text" name="imageURL" placeholder="Image URL" />
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
    <script src="../../assets/js/popper.min.js"></script>
    <script src="../../assets/js/bootstrap.min.js"></script>
    </body>
</html>

