<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
    <tr>
        <td>NAME</td>
        <td>LAST NAME</td>
        <td>LAST NAME</td>
        <td>ADDRESS</td>
        <td>EMAIL</td>
        <td>USER NAME</td>
        <td>PASSWORD</td>
    </tr>

    <c:forEach var="User" items="${userList}">

        <!--Link the userName to the request when updating-->
        <c:url var="linkUpdate" value="UserController">

            <c:param name="action" value="load"/>
            <c:param name="username" value="${User.username}"/>

        </c:url>

        <!--Link the userName to the request when deleting-->
        <c:url var="linkDelete" value="UserController">

            <c:param name="action" value="delete"/>
            <c:param name="username" value="${User.username}"/>

        </c:url>

        <tr>
            <td>${User.name}</td>
            <td>${User.lastName1}</td>
            <td>${User.lastName2}</td>
            <td>${User.address}</td>
            <td>${User.email}</td>
            <td>${User.userName}</td>
            <td>${User.password}</td>
            <td><a href="${linkDelete}" class="icon fa-trash-o"></a></td>
            <td><a href="${linkUpdate}" class="icon fa-pencil"></a></td>

        </tr>

    </c:forEach>

</table>