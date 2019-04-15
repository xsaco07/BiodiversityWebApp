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
        <a href="#work" class="icon fa-search"><span>Observations</span></a>
        <a href="#contact" class="icon fa-user"><span>User settings</span></a>
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
          <a href="#work" class="jumplink pic">
            <span class="arrow icon fa-chevron-right"><span>See my work</span></span>
            <img src="images/jaguar.jpg" align="center" />
          </a>
        </article>

        <!-- Observations -->
        <article id="work" class="panel">
          <header>
            <h2>List of observations</h2>
          </header>
          <p>
            This is the full list of observations made by all the users.
            Below you can add new ones, delete or update the existing.
          </p>
          <section>
            <div class="row">
              <div class="col-4 col-6-medium col-12-small">
                <a href="#" class="image fit"><img src="images/pic01.jpg" alt=""></a>
                <h3>Nombre</h3>
              </div>
              <div class="col-4 col-6-medium col-12-small">
                <a href="#" class="image fit"><img src="images/pic02.jpg" alt=""></a>
                <h3 style="align-content: center">Nombre</h3>
              </div>
              <div class="col-4 col-6-medium col-12-small">
                <a href="#" class="image fit"><img src="images/pic03.jpg" alt=""></a>
                <h3>Nombre</h3>
              </div>
              <div class="col-4 col-6-medium col-12-small">
                <input type="button" value="New observation" onclick="" align="center">
              </div>
              <div class="col-4 col-6-medium col-12-small">
                <input type="button" value="Delete observation" onclick="">
              </div>
              <div class="col-4 col-6-medium col-12-small">
                <input type="button" value="Update observation" onclick="">
              </div>
            </div>
          </section>
        </article>

        <!-- Contact -->
        <article id="contact" class="panel">
          <header>
            <h2>Contact Me</h2>
          </header>
          <form action="#" method="post">
            <div>
              <div class="row">
                <div class="col-6 col-12-medium">
                  <input type="text" name="name" placeholder="Name" />
                </div>
                <div class="col-6 col-12-medium">
                  <input type="text" name="email" placeholder="Email" />
                </div>
                <div class="col-12">
                  <input type="text" name="subject" placeholder="Subject" />
                </div>
                <div class="col-12">
                  <textarea name="message" placeholder="Message" rows="6"></textarea>
                </div>
                <div class="col-4-small col-4-small">
                  <input type="submit" value="Send Message" />
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
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/browser.min.js"></script>
    <script src="assets/js/breakpoints.min.js"></script>
    <script src="assets/js/util.js"></script>
    <script src="assets/js/main.js"></script>

    </body>
</html>
