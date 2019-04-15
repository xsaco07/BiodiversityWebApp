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
            <h2>List of observations</h2>
          </header>

          <p>
            This is the full list of observations made by all the users.
            Below you can add new ones, delete or update the existing.
          </p>

          <section>

              <%@include file="observationList.jsp"%>

            <div class="col-4 col-6-medium col-12-small">
              <a href="#" class="icon fa-plus"></a>
            </div>

          </section>

        </article>

        <!-- Users -->
        <article id="users" class="panel">
          <header>
            <h2>Registered users</h2>
          </header>

          <section>

            <%@include file="userList.jsp"%>

            <div class="col-4 col-6-medium col-12-small">
              <a href="View/UserJSPs/RegisterUser.jsp" class="icon fa-plus"></a>
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
