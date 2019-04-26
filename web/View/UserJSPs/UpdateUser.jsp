<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Update user</title>
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
            <a href="#register" class="icon fa-user-plus"><span>Register</span></a>
        </nav>

        <!-- Main -->
        <div id="main">

            <!-- Register -->
            <article id="register" class="panel">
                <header>
                    <h2>Update user</h2>
                </header>
                <form action="UserController" method="get">

                    <input type="hidden" name="action" value="update">
                    <input type="hidden" name="userName" value="${user.userName}">

                    <div>
                        <div class="row">
                            <div class="col-6 col-12-medium">
                                <input disabled type="text" name="userName" placeholder="UserName" value="${user.userName}" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input disabled type="password" name="pass" placeholder="Password"  value="${user.password}"/>
                            </div>
                            <div class="col-12">
                                <input type="text" name="name" placeholder="Name" value="${user.name}"/>
                            </div>
                            <div class="col-6 col-12-medium">
                                <input type="text" name="last_name1" placeholder="First last name" value="${user.lastName1}" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input type="text" name="last_name2" placeholder="Second last name" value="${user.lastName2}"/>
                            </div>
                            <div class="col-12">
                                <input type="text" name="email" placeholder="Email" value="${user.email}"/>
                            </div>
                            <div class="col-12">
                                <input type="text" name="address" placeholder="Address" rows="6" value="${user.address}"/>
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

