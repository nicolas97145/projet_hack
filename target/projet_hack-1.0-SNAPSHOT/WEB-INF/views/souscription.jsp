<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>SOUSCRIPTION</title>
</head>
<body>

<h1 class="h3">SOUSCRIPTION</h1>

<%--@elvariable id="contrat" type=""--%>
<div class="card">
    <div class="card-body">
        <form:form method="post" action="${pageContext.request.contextPath}/souscription" modelAttribute="contrat">
                <p><form:label class="col-sm-2 col-form-label" path="dateDebutContrat">Date debut de contrat</form:label> <form:input class="form-control form-control-lg" type="date" path="dateDebutContrat"/></p>
                <p><form:label class="col-sm-2 col-form-label" path="dateFinContrat">Date fin de contrat</form:label> <form:input class="form-control form-control-lg" type="date" path="dateFinContrat"/></p>
            <p><button class="btn btn-primary" type="submit">Souscrire</button></p>
        </form:form>
    </div>
</div>
</body>
</html>
