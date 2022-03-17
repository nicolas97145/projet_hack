<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>SOUSCRIPTION</title>
</head>
<body>

<h1>ETUDE CONCERNEE PAR LE CONTRAT</h1>

<%--@elvariable id="etude" type=""--%>
<%--@elvariable id="contrat" type=""--%>
<form:form method="post" action="${pageContext.request.contextPath}/etude" modelAttribute="etude">
    <p><form:label path="cycle">Cycle</form:label> <form:input type="text" path="cycle"/></p>
    <p><form:label path="cursus">Cursus</form:label> <form:input type="text" path="cursus"/></p>
    <p><form:label path="prix">Prix de l'année</form:label> <form:input type="number" path="prix"/></p>

<%--    <p><form:label path="dateDebutContrat">Date debut de contrat</form:label> <form:input type="date" path="dateDebutContrat"/></p>--%>
<%--    <p><form:label path="dateFinContrat">Date fin de contrat</form:label> <form:input type="date" path="dateFinContrat"/></p>--%>

    <p><button type="submit">Souscrire</button></p>
</form:form>
</body>
</html>
