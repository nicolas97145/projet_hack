<%@ taglib prefix="p" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nico-
  Date: 16/03/2022
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>Profil</title>
</head>
<body>

<h2>Bienvenue ${sessionScope.courant}</h2>
    <div class="row">
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Souscrire à un contrat</h5>
                    <p class="card-text">Souscrire à un nouveau contrat proposé par notre assurance.</p>
                    <a href="${pageContext.request.contextPath}/goEtude" class="btn btn-primary">Souscription</a>
                </div>
            </div>
        </div>
        <br>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Consulter un contrat</h5>
                    <p class="card-text">Consulter vos contrats souscrit auprès de notre assurance.</p>
                    <a href="${pageContext.request.contextPath}/contrat" class="btn btn-primary">Consulter</a>
                </div>
            </div>
        </div>
        <br>
        <div class="col-sm-6">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">Déclarer un sinistre</h5>
                    <p class="card-text">Déclarer un sinistre lié à un de vos contrat.</p>
                    <a href="${pageContext.request.contextPath}/sinistre" class="btn btn-primary">Déclarer</a>
                </div>
            </div>
        </div>
    </div>
 <p style="color: red;"> ${sessionScope.erreur} </p>
</body>
<%@ include file="footer.jsp" %>
</html>
