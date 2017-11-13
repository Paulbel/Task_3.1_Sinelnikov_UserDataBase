<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Phone number</th>
        <th>e-mail</th>
    </tr>

    <c:forEach items="${requestScope.userList}" var="item">
        <tr>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.surname}"/></td>
            <td><c:out value="${item.phoneNumber}"/></td>
            <td><c:out value="${item.email}"/></td>
        </tr>

    </c:forEach>

</table>
</body>
</html>

