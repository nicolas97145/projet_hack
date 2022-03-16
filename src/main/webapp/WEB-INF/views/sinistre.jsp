<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Bienvenue</title>
</head>
<body>
Bienvenue, ${username}.

<%--@elvariable id="sinistre" type=""--%>
<form:form method="post" action="${pageContext.request.contextPath}/sinistreDeclare"  modelAttribute="sinistre">
    <p><form:label path="noteS1">note du Semestre 1 : </form:label> <form:input type="text" path="noteS1"/></p>
    <p><form:label path="noteS2">note du Semestre 2 :</form:label> <form:input type="text" path="noteS2"/></p>
    <p><button type="submit">Envoyer</button></p>
    <!-- pour les messages d'erreur globaux au formulaire (pour des messages relatifs à un champ on précise avec "path=") -->
    <form:errors cssStyle="color: red;"></form:errors>
</form:form>

<form action="${pageContext.request.contextPath}/logout">
    <button type="submit">se déconnecter</button>
</form>

<form action="${pageContext.request.contextPath}/simplecheck">
    <button type="submit">Vérifier le login en session (en trace de serveur)</button>
</form>

<jsp:include page="session.jsp"></jsp:include>


</body>
</html>
