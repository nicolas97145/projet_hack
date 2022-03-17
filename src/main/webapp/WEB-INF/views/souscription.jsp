<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>SOUSCRIPTION</title>
    <%@ include file="header.jsp" %>
</head>
<body>

<h1>SOUSCRIPTION</h1>

<%--@elvariable id="contrat" type=""--%>
<div class="card">
    <div class="card-body">
        <form:form method="post" action="${pageContext.request.contextPath}/souscription" modelAttribute="contrat">
            <p><form:label class="col-sm-2 col-form-label" path="dateDebutContrat">Date debut des cours</form:label> <form:input class="form-control form-control-lg" type="date" path="dateDebutContrat"/></p>
            <p><button class="btn btn-primary" type="submit">Souscrire</button></p>
        </form:form>
    </div>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>