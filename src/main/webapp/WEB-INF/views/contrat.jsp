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
    <title>Contrat</title>
    <%@ include file="header.jsp" %>
</head>
<body style="text-align: center">
<h1 class="h3">Contrat en cours</h1>
<p>Numéro du contrat : ${numeroContrat}</p>
<p>Date de début du contrat : ${dateDebutContrat}</p>
<p>Date de fin du contrat : ${dateFinContrat}</p>
<p>Prix du contrat à l'année : ${prixAnnuel} €</p>
<c:if test="${ not empty sinistreDate}">
<p>Sinistre : ${sinistreDate}
    Pourcentage : ${sinistrePourcentage}
    Indemnite : ${sinistreIndemn}</p>
</c:if>
</body>
<%@ include file="footer.jsp" %>
</html>
