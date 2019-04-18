<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

    <head>
        <title>Species images gallery</title>
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
            <a href="#images" class="icon fa-image"><span>Observations</span></a>
        </nav>

        <!-- Main -->
        <div id="main">

            <!-- Observations -->
            <article id="images" class="panel">

                <header>
                    <h2>Gallery</h2>
                </header>

                <section>

                    <div class="row">

                        <c:forEach var="Image" items="${imageList}">

                            <!--Link the imageId to the request when updating-->
                            <c:url var="linkUpdate" value="ImageController">

                                <c:param name="action" value="load"/>
                                <c:param name="imageId" value="${Image.imageId}"/>

                            </c:url>

                            <!--Link the imageId to the request when deleting-->
                            <c:url var="linkDelete" value="ImageController">

                                <c:param name="action" value="delete"/>
                                <c:param name="imageId" value="${Image.imageId}"/>

                            </c:url>


                            <div class="col-4 col-6-medium col-12-small">
                                <a href="#" class="image fit"><img width="200" height="175" src="${Image.imageURL}" alt=""></a>

                                <b>Photographer</b>
                                <br>
                                    ${Image.photographerName}
                                <br>
                                <b>Specie</b>
                                <br>
                                    ${Image.specieName}
                                <br>
                                <b>Date</b>
                                <br>
                                    ${Image.date}
                                <br>
                                <b>Took in</b>
                                <br>
                                    ${Image.country}, ${Image.province}
                                <br>
                                <b>Owner</b>
                                <br>
                                    ${Image.owner}
                                <br>
                                <a href="${linkDelete}" style="margin: 8px" class="icon fa-trash-o"></a>
                                <a href="${linkUpdate}" style="margin: 8px" class="icon fa-pencil"></a>

                            </div>

                        </c:forEach>

                    </div>

                    <div class="row">
                        <div class="col-4 col-6-medium col-12-small">
                            <a href="View/ImageJSPs/RegisterImage.jsp" class="icon fa-plus"></a>
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