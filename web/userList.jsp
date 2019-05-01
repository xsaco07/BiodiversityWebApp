<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>User List</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/main.css" />
        <noscript><link rel="stylesheet" href="assets/css/noscript.css" /></noscript>
    </head>

    <body class="is-preload">

    <!-- Wrapper-->
    <div id="wrapper">

        <!-- Nav -->
        <nav id="nav">
            <a href="#users" class="icon fa-user"><span>Observations</span></a>
            <a href="index.jsp" class="icon fa-home"><span>Home</span></a>
        </nav>

        <!-- Main -->
        <div id="main">

            <!-- Observations -->
            <article id="users" class="panel">

                <header>
                    <h2>List of users</h2>
                </header>

                <p>
                    This is the full list of users.
                    Below you can add new ones, delete or update the existing.
                </p>

                <section>

                    <table>
                        <tr style="text-align: center">
                            <td><strong style="margin: 5px">NAME</strong></td>
                            <td><strong style="margin: 5px">L.NAME 1</strong></td>
                            <td><strong style="margin: 5px">L.NAME 2</strong></td>
                            <td><strong style="margin: 5px">ADDRESS</strong></td>
                            <td><strong style="margin: 5px">EMAIL</strong></td>
                            <td><strong style="margin: 5px">WEB NAME</strong></td>
                            <td><strong style="margin: 5px">PASS</strong></td>
                            <td><strong style="margin: 5px">ACTION</strong></td>
                        </tr>

                        <c:forEach var="User" items="${userList}">

                            <!--Link the userName to the request when updating-->
                            <c:url var="linkUpdate" value="UserController">

                                <c:param name="action" value="load"/>
                                <c:param name="username" value="${User.userName}"/>

                            </c:url>

                            <!--Link the userName to the request when deleting-->
                            <c:url var="linkDelete" value="UserController">

                                <c:param name="action" value="delete"/>
                                <c:param name="username" value="${User.userName}"/>

                            </c:url>

                            <tr>
                                <td>${User.name}</td>
                                <td>${User.lastName1}</td>
                                <td>${User.lastName2}</td>
                                <td>${User.address}</td>
                                <td>${User.email}</td>
                                <td>${User.userName}</td>
                                <td>${User.password}</td>
                                <td>
                                    <a href="${linkDelete}" style="font-size: 25px; margin: 10px" class="icon fa-trash-o"></a>
                                    <a href="${linkUpdate}" style="font-size: 25px; margin: 10px" class="icon fa-pencil"></a>
                                </td>

                            </tr>

                        </c:forEach>

                    </table>

                    <div style="text-align: center;">
                        <br>
                        <a style="font-size: 50px; display: block; margin: 0 auto" href="View/UserJSPs/RegisterUser.jsp" class="icon fa-plus"></a>
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
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    </body>

</html>