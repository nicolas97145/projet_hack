<%--
  Created by IntelliJ IDEA.
  User: nico-
  Date: 17/03/2022
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="header.jsp" %>
    <title>Annulation</title>
</head>
<body>
<div style="text-align: center">
    <p>Votre demande de remboursement a été rejetée.</p>
Raison :  <p style="color: red">${erreur}</p></div>
</body>
<%@ include file="footer.jsp" %>
</html>
