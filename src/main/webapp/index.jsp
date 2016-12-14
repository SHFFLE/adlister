<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="partials/navbar.jsp" %>
<html>
<jsp:include page="partials/header.jsp">
    <jsp:param name="title" value="Index" />
</jsp:include>
<body>
<main>
<div id="content">
    <div>
    <c:if test="true">
        <h1>Variable names should be very descriptive</h1>
    </c:if>
    <c:if test="false">
        <h1>single letter variable names are good</h1>
    </c:if>
    </div>
</div>
</main>
</body>
</html>
