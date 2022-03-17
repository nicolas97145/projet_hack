<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>SOUSCRIPTION</title>
</head>
<body>

<h1 class="h3">ETUDE CONCERNEE PAR LE CONTRAT</h1>

<%--@elvariable id="etude" type=""--%>
<div class="card">
    <div class="card-body">
        <form:form method="post" action="${pageContext.request.contextPath}/etude" modelAttribute="etude">
            <p><form:label class="col-sm-2 col-form-label" path="annee">Année supérieure</form:label><form:select class="form-control form-control-lg" path="annee">
                <form:option value="0">--Sélectionnez---</form:option>
                <form:option value="1">Première année</form:option>
                <form:option value="2">Deuxième année</form:option>
                <form:option value="3">Troisième année</form:option>
                <form:option value="4">Quatrième année</form:option>
                <form:option value="5">Cinquième année</form:option>
            </form:select></p>
            <p><form:label class="col-sm-2 col-form-label" path="cycle">Cycle</form:label><form:select class="form-control form-control-lg" path="cycle">
                <form:option value="0">--Sélectionnez---</form:option>
                <form:option value="BTS">BTS</form:option>
                <form:option value="DUT">DUT</form:option>
                <form:option value="LICENCE">LICENCE</form:option>
                <form:option value="MASTER">MASTER</form:option>
            </form:select></p>
            <p><form:label class="col-sm-2 col-form-label" path="cursus">Cursus</form:label> <form:input class="form-control form-control-lg" type="text" path="cursus"/></p>
            <p><form:label class="col-sm-2 col-form-label" path="prix">Prix de l'année</form:label> <form:input class="form-control form-control-lg" type="number" path="prix"/></p>
            <p><button class="btn btn-primary" type="submit">Valider</button></p>
        </form:form>
    </div>
</div>
</body>
</html>