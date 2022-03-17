<%--
  Created by IntelliJ IDEA.
  User: nico-
  Date: 17/03/2022
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
    <%@ include file="header.jsp" %>
</head>
<body>

<p style="text-align: center">Votre demande a bien été prise en compte</p>
<div style="text-align: center">
<h1 class="h3">RACAPITULATIF DE LA DEMANDE</h1>
<p>Date de la demande: ${dateDeclaration}</p>
<p>Pourcentage de remboursement : ${pourcentageRemboursement}</p>
<p>Indemnités versées : ${indemnite}</p>
<br>
    <p>L'indemnité vous sera versée après verification de votre bulletin et de votre présence aux examens.</p>
<a href="${pageContext.request.contextPath}/profil">Retour</a>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
