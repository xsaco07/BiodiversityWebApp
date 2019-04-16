<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <td>ID</td>
        <td>LATITUDE</td>
        <td>LONGITUDE</td>
        <td>SPECIE</td>
        <td>DATE</td>
        <td>USER</td>
        <td>IMAGE</td>
    </tr>

    <c:forEach var="Observation" items="${observationList}">

        <!--Link the userName to the request when updating-->
        <c:url var="linkUpdate" value="ObserverController">

            <c:param name="action" value="load"/>
            <c:param name="observationId" value="${Observation.observationId}"/>

        </c:url>

        <!--Link the userName to the request when deleting-->
        <c:url var="linkDelete" value="ObserverController">

            <c:param name="action" value="delete"/>
            <c:param name="observationId" value="${Observation.observationId}"/>

        </c:url>

        <tr>
            <td>${Observation.observationId}</td>
            <td>${Observation.latitude}</td>
            <td>${Observation.longitude}</td>
            <td>${Observation.date}</td>
            <td>${Observation.specieName}</td>
            <td>${Observation.userName}</td>
            <td>${Observation.imageURL}</td>
            <td><a href="${linkDelete}" class="icon fa-trash-o"></a></td>
            <td><a href="${linkUpdate}" class="icon fa-pencil"></a></td>

        </tr>

    </c:forEach>

</table>