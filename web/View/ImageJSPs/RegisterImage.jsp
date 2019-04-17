<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
        <title>New image</title>
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
            <a href="#register" class="icon fa-plus-square"><span>Register</span></a>
        </nav>

        <!-- Main -->
        <div id="main">

            <!-- Register -->
            <article id="register" class="panel">
                <header>
                    <h2>New image</h2>
                </header>
                <form action="/ImageController" method="post">

                    <input type="hidden" name="action" value="insert">

                    <div>
                        <div class="row">
                            <div class="col-6 col-12-medium">
                                <input type="text" name="url" placeholder="URL" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input type="text" name="photographer" placeholder="Photographer" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input type="text" name="specieName" placeholder="Specie name" />
                            </div>
                            <div class="col-12">
                                <input type="date" name="date" placeholder="Date" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input type="text" name="country" placeholder="Country" />
                            </div>
                            <div class="col-6 col-12-medium">
                                <input type="text" name="province" placeholder="Province" />
                            </div>
                            <div class="col-12">
                                <input type="text" name="owner" placeholder="Owner name" />
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


