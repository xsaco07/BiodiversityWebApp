<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

    <head>
      <title>Taxon</title>
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
        <a href="#observations" class="icon fa-search"><span>Observations</span></a>
        <a href="#users" class="icon fa-user"><span>User settings</span></a>
        <a href="#images" class="icon fa-image"><span>Images</span></a>
        <a href="View/UserJSPs/login.jsp" class="icon fa-sign-out"><span>Log out</span></a>
      </nav>

      <!-- Main -->
      <div id="main">

        <!-- Me -->
        <article id="home" class="panel intro">
          <header>
            <h1>Welcome to</h1>
            <h1>Naturalist</h1>
            <p>Update and visualize BIO-INFO</p>
          </header>
          <a href="#observations" class="jumplink pic">
            <span class="arrow icon fa-chevron-right"><span>See my work</span></span>
            <img src="images/jaguar.jpg" align="center" />
          </a>
        </article>

        <!-- Observations -->
        <article id="observations" class="panel">
          <header>
            <h2>Observations</h2>
          </header>

          <p align="center">
            Every time a user records any specie any where and want to share it, he or she will
            make an <b>Observation</b>. You can do it whenever you want. If you made a mistake
            you can update or delete any observation.
          </p>

            <img style="box-shadow: 12px 12px 12px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); border: 8px solid #d7d7d7; display: block; margin: 0 auto" src="assets/css/images/photographer.png" width="400" height="300" alt="">

            <br>

            <form action="ObserverController" method="get">
                <input type="hidden" name="action" value="list">
                <input style="box-shadow: 8px 8px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); display: block; margin: 0 auto" type="submit" value="View all observations">
            </form>

        </article>

        <!-- Users -->
        <article id="users" class="panel">

          <header>
            <h2>Users</h2>
          </header>

            <p align="center">
                <b>Users</b> can make the observations in this web page.
            </p>

            <img style="box-shadow: 12px 12px 12px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); border: 8px solid #d7d7d7; display: block; margin: 0 auto" src="assets/css/images/user2.jpg" width="250" height="250" alt="">

            <br>

            <form action="UserController" method="get">
                <input type="hidden" name="action" value="list">
                <input style="box-shadow: 8px 8px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); display: block; margin: 0 auto" type="submit" value="View all users">
            </form>

        </article>

        <!-- Images -->
        <article id="images" class="panel">
          <header>
            <h2>Specie images</h2>
          </header>

            <p align="center">
                We store <b>Specie Images</b> so the users can look for examples of another photographers.
                You can add new ones whenever you want or update it if you made a mistake while creating a new one.
            </p>

            <img style="border: 8px solid #d7d7d7; box-shadow: 12px 12px 12px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); display: block; margin: 0 auto" src="assets/css/images/animal.jpg" width="480" height="300" alt="">

            <br>

            <form action="ImageController" method="get">
                <input type="hidden" name="action" value="list">
                <input style="box-shadow: 8px 8px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19); display: block; margin: 0 auto" type="submit" value="View gallery">
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
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/browser.min.js"></script>
    <script src="assets/js/breakpoints.min.js"></script>
    <script src="assets/js/util.js"></script>
    <script src="assets/js/main.js"></script>

    </body>
</html>
