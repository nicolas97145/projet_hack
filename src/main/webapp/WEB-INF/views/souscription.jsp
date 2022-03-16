<%--
  Created by IntelliJ IDEA.
  User: o2198221
  Date: 16/03/2022
  Time: 14:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>SOUSCRIPTION CONTRAT</h1>

<form:form method="post" action="${pageContext.request.contextPath}/souscription">
    <p><form:label path="mail">login</form:label> <form:input type="text" path="mail"/></p>
    <p><form:label path="password">mot de passe</form:label> <form:input type="password" path="password"/></p>
    <p><button type="submit">Envoyer</button></p>
</form:form>

</body>
</html>
