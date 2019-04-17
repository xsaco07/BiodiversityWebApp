<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
