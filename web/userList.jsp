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

        <tr>
            <td>${User.name}</td>
            <td>${User.lastName1}</td>
            <td>${User.lastName2}</td>
            <td>${User.address}</td>
            <td>${User.email}</td>
            <td>${User.userName}</td>
            <td>${User.password}</td>
            <td><a href="View/UserJSPs/RegisterUser.jsp" class="icon fa-trash-o"></a></td>
            <td><a href="View/UserJSPs/RegisterUser.jsp" class="icon fa-pencil"></a></td>

        </tr>

    </c:forEach>

</table>