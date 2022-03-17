<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Inscription</title>
</head>
<body>
<h1 class="h3">INSCRIPTION</h1>
<!-- on utilise form:form qui vient de spring mvc et on précise le modelAttribute. Sinon ls messages d'erreur ne sont pas traités -->
<%--@elvariable id="user" type=""--%>
<div class="card">
    <div class="card-body">
<form:form method="post" action="${pageContext.request.contextPath}/inscription"  modelAttribute="user">
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
    <p><form:label class="col-sm-2 col-form-label" path="password">Confirmer Mot de Passe</form:label> <form:password class="form-control form-control-lg" path="password"/></p>
    <p><form:label class="col-sm-2 col-form-label"  path="bac">Baccalauréat</form:label>
<%--    <form:option value="NONE"> --Sélectionnez une spécialité--</form:option>--%>
<%--        <form:options items="${listSpecialitiesBac}"></form:options>--%>
<%--    </form:select>--%>
    <select class="form-control form-control-lg" name="specs" id="bac">
        <option value="">--Sélectionnez---</option>
            <c:forEach items="${listSpecialitiesBac}" var="specBacs" varStatus="loop">
                <option value="${loop}">
                        ${specBacs}
                </option>
            </c:forEach>
    </select>
    </p>
    <%--    <p><form:label path="sexe">sexe</form:label> <form:radiobutton path="sexe" value="homme"/> <form:radiobutton path="sexe" value="femmme"/> </p>--%>




    <p><button class="btn btn-primary" type="submit">Envoyer</button></p>
    <!-- pour les messages d'erreur globaux au formulaire (pour des messages relatifs à un champ on précise avec "path=") -->
    <%--<form:errors cssStyle="color: red;"></form:errors>--%>
</form:form>
    </div>
</div>


<c:import url="session.jsp"></c:import>

</body>
</html>
