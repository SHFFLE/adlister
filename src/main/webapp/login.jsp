<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="partials/navbar.jsp" %>

<html>
<jsp:include page="partials/header.jsp">
    <jsp:param name="title" value="Please Log In" />
</jsp:include>
<body>
<main>
    <div id="content">
        <form action="/login" method="post">
            <input type="text" name="username">
            <input type="password" name="password">
            <button type="submit">Submit</button>
        </form>
    </div>
</main>
</body>
</html>
