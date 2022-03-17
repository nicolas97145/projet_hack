<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nico-
  Date: 16/03/2022
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contrats</title>
    <%@ include file="header.jsp" %>
</head>
<body>


<p style="text-align: center">${sessionScope.testContrat}</p>


<c:if test="${ not empty sessionScope.contrat}">
    <p style="text-align: center">Contrats : </p>
    <c:forEach var="unContrat" items="${ contrat }">
        <li><c:out value="${ unContrat.numeroContrat }" />
            <c:out value="${ unContrat.dateDébutContrat }" />
            <c:out value="${ unContrat.dateFinContrat }" />
            <c:out value="${ unContrat.prixAnnuel }" />
    </c:forEach>
</c:if>

</body>
<%@ include file="footer.jsp" %>
</html>
