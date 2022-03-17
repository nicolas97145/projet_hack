<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
     <title>RECAPITULATIF</title>
    <%@ include file="header.jsp" %>
</head>
<body style="text-align: center">
<h1 class="h3">RECAPITULATIF DU CONTRAT</h1>
<p>Année d'étude supérieure : ${anneeEtude}</p>
<p>Cycle : ${cycle}</p>
<p>Cursus : ${cursus}</p>
<p>Prix de l'année d'étude : ${prix}</p>
 <br>
<p>Date de début du contrat : ${dateDebutContrat}</p>
<p>Date de fin du contrat : ${dateFinContrat}</p>
<p>Prix du contrat à l'année : ${prixContrat} €</p>
</body>
<%@ include file="footer.jsp" %>
</html>