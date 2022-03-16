<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- la taglib pour afficher entre autres les messages d'erreur...) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
    <title>Identification</title>
    <%@ include file="header.jsp" %>
</head>
<body>

<section class="vh-100" style="background-color: #508bfc;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <h3 class="mb-5">Connexion</h3>
                        <%--@elvariable id="user" type=""--%>
                        <form:form method="post" action="${pageContext.request.contextPath}/user"  modelAttribute="user">
                        <div class="form-outline mb-4">
                            <p><form:input id="typeEmailX-2" type="text" path="mail" class="form-control form-control-lg"/></p>
                            <label class="form-label" for="typeEmailX-2">Email</label>
                        </div>

                        <div class="form-outline mb-4">
                            <p><form:input id="typePasswordX-2" class="form-control form-control-lg" type="password" path="password"/></p>
                            <label class="form-label" for="typePasswordX-2">Password</label>
                        </div>

                        <button class="btn btn-primary btn-lg btn-block" type="submit">Connexion</button>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
<%@ include file="footer.jsp" %>
</html>
