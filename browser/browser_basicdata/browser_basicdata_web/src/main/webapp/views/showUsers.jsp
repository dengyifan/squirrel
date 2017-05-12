<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示所有的用户</title>
</head>
<body>
<form>
    <table >
        <c:forEach var="user" items="${list}">
            <tr>
                <td>${user.userId}</td>
                <td>${user.name}</td>
                <td>${user.depId}</td>
                <td>${user.sex}</td>
            </tr>
        </c:forEach>
    </table>
</form>

</body>
</html>