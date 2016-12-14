
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="partials/navbar.jsp" %>

<%! String username; %>
<% username = request.getParameter("username"); %>
<%! String password; %>
<% password = request.getParameter("password"); %>
<% if (username != null && username.equals("admin") && password != null && password.equals("password")){
        response.sendRedirect("/profile.jsp");
    } else if (username != null && password!= null){
        response.sendRedirect("/login.jsp");
    }
%>

<html>
<jsp:include page="partials/header.jsp">
    <jsp:param name="title" value="Please Log In" />
</jsp:include>
<body>
<main>
    <div id="content">
        <form action="login.jsp" method="post">
            <input type="text" name="username">
            <input type="password" name="password">
            <button type="submit">Submit</button>
        </form>
    </div>
</main>
</body>
</html>
