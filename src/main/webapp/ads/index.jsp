<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Ads" />
    </jsp:include></head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<table class="table table-striped">
    <thead>
        <tr>
            <th>ID</th>
            <th>User ID</th>
            <th>Title</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="ad" items="${ads}">
            <tr>
                <td>${ad.id}</td>
                <td>${ad.userId}</td>
                <td>${ad.title}</td>
                <td>${ad.description}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
