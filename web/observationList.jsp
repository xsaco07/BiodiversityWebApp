<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Observations List</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="assets/css/main.css" />
        <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
    </head>

    <body class="is-preload">

    <!-- Wrapper-->
    <div id="wrapper">

        <!-- Nav -->
        <nav id="nav">
            <a href="#observations" class="icon fa-search"><span>Observations</span></a>
            <a href="#" class="icon fa-home"><span>Home</span></a>
        </nav>

        <!-- Main -->
        <div id="main">

            <!-- Observations -->
            <article id="observations" class="panel">

                <header>
                    <h2>List of Observations</h2>
                </header>

                <p>
                    This is the full list of observations made by all the users.
                    Below you can add new ones, delete or update the existing
                </p>

                <section>

                    <table>
                        <tr>
                            <td>ID</td>
                            <td>LATITUDE</td>
                            <td>LONGITUDE</td>
                            <td>SPECIE</td>
                            <td>DATE</td>
                            <td>USER</td>
                            <td>IMAGE</td>
                        </tr>

                        <c:forEach var="Observation" items="${observationList}">

                            <!--Link the userName to the request when updating-->
                            <c:url var="linkUpdate" value="ObserverController">

                                <c:param name="action" value="load"/>
                                <c:param name="observationId" value="${Observation.observationId}"/>

                            </c:url>

                            <!--Link the userName to the request when deleting-->
                            <c:url var="linkDelete" value="ObserverController">

                                <c:param name="action" value="delete"/>
                                <c:param name="observationId" value="${Observation.observationId}"/>

                            </c:url>

                            <tr>
                                <td>${Observation.observationId}</td>
                                <td>${Observation.latitude}</td>
                                <td>${Observation.longitude}</td>
                                <td>${Observation.date}</td>
                                <td>${Observation.specieName}</td>
                                <td>${Observation.userName}</td>
                                <td>${Observation.imageURL}</td>
                                <td><a href="${linkDelete}" class="icon fa-trash-o"></a></td>
                                <td><a href="${linkUpdate}" class="icon fa-pencil"></a></td>

                            </tr>

                        </c:forEach>

                    </table>

                    <c:url var="linkRegister" value="ObserverController">

                        <c:param name="action" value="register"/>

                    </c:url>

                    <div class="row">
                        <div class="col-4 col-6-medium col-12-small">
                            <a href="${linkRegister}" class="icon fa-plus"></a>
                        </div>
                    </div>

                </section>

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
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/browser.min.js"></script>
    <script src="assets/js/breakpoints.min.js"></script>
    <script src="assets/js/util.js"></script>
    <script src="assets/js/main.js"></script>

    </body>
</html>