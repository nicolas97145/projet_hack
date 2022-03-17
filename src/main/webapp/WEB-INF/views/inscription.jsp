<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <%@ include file="header.jsp" %>
    <title>Inscription</title>
</head>
<body>
<h1 class="h3">INSCRIPTION</h1>
<!-- on utilise form:form qui vient de spring mvc et on précise le modelAttribute. Sinon ls messages d'erreur ne sont pas traités -->
<%--@elvariable id="user" type=""--%>
<div class="card">
    <div class="card-body">
        <form:form method="post" action="${pageContext.request.contextPath}/inscriptionUser"  modelAttribute="user">
        <p><form:label path="nom">Nom</form:label> <form:input class="form-control form-control-lg" type="text" path="nom"/></p>
        <p><form:label path="prenom">Prénom</form:label> <form:input class="form-control form-control-lg" type="text" path="prenom"/></p>
        <p><form:label path="dateNaissance">Date de Naissance</form:label> <form:input class="form-control form-control-lg" type="date" path="dateNaissance"/></p>
        <p><form:label class="col-sm-2 col-form-label" path="sexe">Sexe</form:label> <br>
            <div class="custom-control custom-radio custom-control-inline">
        <p><form:radiobutton class="col-sm-2 col-form-label" path="sexe" value="Homme"/>Homme</p>
        <p><form:radiobutton class="col-sm-2 col-form-label" path="sexe" value="Femme"/>Femme</p>
    </div>
    <p><form:label class="col-sm-2 col-form-label" path="mail">Adresse Mail</form:label> <form:input class="form-control form-control-lg" type="text" path="mail"/></p>
    <p><form:label class="col-sm-2 col-form-label" path="password">Mot de Passe</form:label> <form:password class="form-control form-control-lg" path="password"/></p>
    <p><form:label class="col-sm-2 col-form-label" path="bac">Cycle</form:label><form:select class="form-control form-control-lg" path="bac">
        <form:option value="0">--Sélectionnez---</form:option>
        <form:option value="GENERAL">GENERAL</form:option>
        <form:option value="PROFESSIONNEL">PROFESSIONNEL</form:option>
        <form:option value="TECHNOLOGIQUE">TECHNOLOGIQUE</form:option>
    </form:select></p>

    <p><button class="btn btn-primary" type="submit">Envoyer</button></p>

    </form:form>
</div>
</div>

</body>
</html>