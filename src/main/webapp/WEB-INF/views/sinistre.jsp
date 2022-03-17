<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nico-
  Date: 17/03/2022
  Time: 08:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sinistre</title>
    <%@ include file="header.jsp" %>
</head>
<body>

<%--@elvariable id="sinistre" type=""--%>
<form:form method="post" action="${pageContext.request.contextPath}/sinistreDeclare"  modelAttribute="sinistre">
    <p><form:label path="noteS1">note du Semestre 1 : </form:label> <form:input type="text" path="noteS1"/></p>
    <p><form:label path="noteS2">note du Semestre 2 :</form:label> <form:input type="text" path="noteS2"/></p>
    <input type="file" name="file" size="50" />
    <p><button type="submit">Envoyer</button></p>
</form:form>


</body>
<%@ include file="footer.jsp" %>
</html>
