<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04/11/2023
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Users</h1>

<table>

    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th colspan="3">Email</th>
    </tr>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td><a href="userAdmin?action=display_user&amp;email=${user.email}">Update</a></td>
            <td><a href="userAdmin?action=delete_user&amp;email=${user.email}">Delete</a></td>
        </tr>
    </c:forEach>

</table>

<p><a href="userAdmin">Refresh</a></p>

</body>
</html>
