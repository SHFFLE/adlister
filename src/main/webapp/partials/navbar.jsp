<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/navbar.css">
<nav>
    <ul>
        <li class="header">Nicholas Ring</li>
        <a href="./index.jsp"><li class="list-link">Home</li></a>
        <a href="./login.jsp"><li class="list-link">Login</li></a>
        <a href="#"><li class="list-submenu-header">Projects</li></a>
        <ul class="list-submenu">
            <a href="#"><li class="list-link">Calculator</li></a>
            <a href="#"><li class="list-link">Simon</li></a>
            <a href="#"><li class="list-link">Weather Map</li></a>
        </ul>
    </ul>
</nav>
<script src="https://code.jquery.com/jquery-3.1.1.js"
integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA="
crossorigin="anonymous"></script>
<script src="./js/navbar.js"></script>
