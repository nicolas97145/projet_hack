<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>RECAPITULATIF</title>
</head>
<body>
<h1 class="h3">RACAPITULATIF DU CONTRAT</h1>
<p>Année d'étude supérieure : ${anneeEtude}</p>
<p>Cycle : ${cycle}</p>
<p>Cursus : ${cursus}</p>
<p>Prix de l'année d'étude : ${prix}</p>

<p>Date de début du contrat : ${dateDebutContrat}</p>
<p>Date de fin du contrat : ${dateFinContrat}</p>
</body>
</html>
