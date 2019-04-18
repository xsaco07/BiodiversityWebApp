<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>User List</title>
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
            <a href="#" class="icon fa-home"><span>Home</span></a>
            <a href="#users" class="icon fa-user"><span>Observations</span></a>
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
                        <tr>
                            <td>NAME</td>
                            <td>LAST NAME</td>
                            <td>LAST NAME</td>
                            <td>ADDRESS</td>
                            <td>EMAIL</td>
                            <td>USER NAME</td>
                            <td>PASSWORD</td>
                        </tr>

                        <c:forEach var="User" items="${userList}">

                            <!--Link the userName to the request when updating-->
                            <c:url var="linkUpdate" value="UserController">

                                <c:param name="action" value="load"/>
                                <c:param name="username" value="${User.username}"/>

                            </c:url>

                            <!--Link the userName to the request when deleting-->
                            <c:url var="linkDelete" value="UserController">

                                <c:param name="action" value="delete"/>
                                <c:param name="username" value="${User.username}"/>

                            </c:url>

                            <tr>
                                <td>${User.name}</td>
                                <td>${User.lastName1}</td>
                                <td>${User.lastName2}</td>
                                <td>${User.address}</td>
                                <td>${User.email}</td>
                                <td>${User.userName}</td>
                                <td>${User.password}</td>
                                <td><a href="${linkDelete}" class="icon fa-trash-o"></a></td>
                                <td><a href="${linkUpdate}" class="icon fa-pencil"></a></td>

                            </tr>

                        </c:forEach>

                    </table>

                    <div class="row">
                        <div class="col-4 col-6-medium col-12-small">
                            <a href="View/UserJSPs/RegisterUser.jsp" class="icon fa-plus"></a>
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