<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>Logging Page</title>
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
            <a href="#logging" class="icon fa-user"><span>Log In</span></a>
        </nav>

        <!-- Main -->
        <div id="main">

            <!-- Logging -->
            <article id="logging" class="panel">
                <header>
                    <h2>Log in</h2>
                </header>
                <form action="/ServletLogin" method="post">
                    <div>
                        <div class="row">
                            <div class="col-6 col-12-medium">
                                <input required type="text" name="userName" placeholder="User name" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input required type="password" name="password" placeholder="Password" />
                            </div>
                            <div class="col-12">
                                <input type="submit" value="Access" />
                                <input type="button" value="Sign Up" onclick="window.location.href='../../View/UserJSPs/RegisterUser.jsp'" style="padding: 15px; background: #444444; border: #888888; border-radius: 10px">
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
