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
            <a href="#" class="icon fa-image"><span>Images</span></a>
            <a href="/index.jsp" class="icon fa-home"><span>Home</span></a>
        </nav>

        <!-- Main -->
        <div id="main">

            <!-- Images -->
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

                                <a href="#" style="border: 8px solid #d7d7d7; box-shadow: 12px 12px 12px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)" class="image fit"><img src="${Image.imageURL}" alt=""></a>

                                <br>

                                <div style="text-align: center; border: double 7px #cbcbcb">
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
                                        ${Image.dateToString()}
                                    <br>
                                    <b>Took in</b>
                                    <br>
                                        ${Image.country}, ${Image.province}
                                    <br>
                                    <b>Owner</b>
                                    <br>
                                        ${Image.owner}
                                    <br>

                                    <a href="${linkDelete}" style="font-size: 25px; margin: 8px" class="icon fa-trash-o"></a>
                                    <a href="${linkUpdate}" style="font-size: 25px; margin: 8px" class="icon fa-pencil"></a>
                                </div>

                            </div>

                        </c:forEach>

                    </div>

                    <div style="text-align: center;">
                        <br>
                        <a style="font-size: 50px; display: block; margin: 0 auto" href="View/ImageJSPs/RegisterImage.jsp" class="icon fa-plus"></a>
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