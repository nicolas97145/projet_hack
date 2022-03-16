<%--
  Created by IntelliJ IDEA.
  User: nico-
  Date: 16/03/2022
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="#">Accueil <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/login">Connexion</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Inscription</a>
            </li>
            <c:if test="${ not empty sessionScope.courant}">
                <li class="nav-item">
                    <a class="nav-link" href="#">Déconnexion</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>

</body>
</html>
