<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>SOUSCRIPTION CONTRAT</h1>

<!-- on utilise form:form qui vient de spring mvc et on précise le modelAttribute. Sinon ls messages d'erreur ne sont pas traités -->
<%--@elvariable id="user" type=""--%>

<form:form method="post" action="${pageContext.request.contextPath}/souscription">
    <p><form:label path="cycle">Date fin de contrat</form:label> <form:input type="text" path="cycle"/></p>
    <p><form:label path="cursus">Date debut de contrat</form:label> <form:input type="text" path="cursus"/></p>
    <p><form:label path="prixAnnee">Date debut de contrat</form:label> <form:input type="number" path="prixAnnee"/></p>

    <p><form:label path="dateDebutContrat">Date fin de contrat</form:label> <form:input type="date" path="dateDebutContrat"/></p>
    <p><form:label path="dateFinContrat">Date debut de contrat</form:label> <form:input type="date" path="dateFinContrat"/></p>
    <p><button type="submit">Souscrire</button></p>
</form:form>

</body>
</html>
