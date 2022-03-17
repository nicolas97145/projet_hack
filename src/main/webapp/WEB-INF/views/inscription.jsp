<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Inscription</title>
</head>
<body>
<h1>INSCRIPTION</h1>
<!-- on utilise form:form qui vient de spring mvc et on précise le modelAttribute. Sinon ls messages d'erreur ne sont pas traités -->
<%--@elvariable id="user" type=""--%>
<form:form method="post" action="${pageContext.request.contextPath}/inscription"  modelAttribute="user">
    <p><form:label path="nom">nom</form:label> <form:input type="text" path="nom"/></p>
    <p><form:label path="prenom">prenom</form:label> <form:input type="text" path="prenom"/></p>
    <p><form:label path="dateNaissance">date de naissance</form:label> <form:input type="date" path="dateNaissance"/></p>
    <p><form:label path="sexe">sexe</form:label> <br>
        <label> Homme </label>
        <form:radiobutton path="sexe" value="homme"/>
        <label> Femme </label>
        <form:radiobutton path="sexe" value="femme"/>
    </p>
    <p><form:label path="mail">mail</form:label> <form:input type="text" path="mail"/></p>
    <p><form:label path="password">mot de passe</form:label> <form:password path="password"/></p>
    <p><form:label path="bac">Bac</form:label>
<%--    <form:option value="NONE"> --Sélectionnez une spécialité--</form:option>--%>
<%--        <form:options items="${listSpecialitiesBac}"></form:options>--%>
<%--    </form:select>--%>
    <select name="specs" id="bac">
        <option value="">--Sélectionnez---</option>
            <c:forEach items="${listSpecialitiesBac}" var="specBacs" varStatus="loop">
                <option value="${loop}">
                        ${specBacs}
                </option>
            </c:forEach>
    </select>
    </p>
    <%--    <p><form:label path="sexe">sexe</form:label> <form:radiobutton path="sexe" value="homme"/> <form:radiobutton path="sexe" value="femmme"/> </p>--%>




    <p><button type="submit">Envoyer</button></p>
    <!-- pour les messages d'erreur globaux au formulaire (pour des messages relatifs à un champ on précise avec "path=") -->
    <%--<form:errors cssStyle="color: red;"></form:errors>--%>
</form:form>


<c:import url="session.jsp"></c:import>

</body>
</html>
