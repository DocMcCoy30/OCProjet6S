<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <title>Accueil</title>
</head>
<body>
<c:url value="/logout" var="logoutUrl"/>
<script>
    function formSubmit() {
        document.getElementById("logoutForm").submit();
    }
</script>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}"><h2>Les amis de l'escalade</h2></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <%--        <div class="navbar-nav">--%>
        <%--            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/accueil">Accueil<span--%>
        <%--                    class="sr-only">(current)</span></a>--%>
        <%--            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/sites">Sites</a>--%>
        <%--        </div>--%>
    </div>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/signin">Creer un compte</a>
        &nbsp
        <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/login">Se connecter</a>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div>Bonjour ${pageContext.request.userPrincipal.name}</div>
        &emsp;
        <form action="${logoutUrl}" method="post" id="logoutForm">
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
            <a class="btn btn-outline-primary" href="javascript:formSubmit()">Se déconnecter</a>
        </form>
    </c:if>
</nav>

<br><br>
<div class="container-fluid">
    <div class="card">
        <h2>
            <div class="card-title">Ajouter un nouveau secteur</div>
        </h2>
        <form action="creationSecteur" method="post">
            <div class="row col-md-12 no-gutters">
                <div class="input-group col-lg">
                    <div class="input-group-prepend">
                        <c:set var="site" value="${site}"/>
                        <input id="siteId" name="siteId" type="hidden" value="${site.id}">
                        <span class="input-group-text" id="siteNom">Nom du site : </span>
                    </div>
                    <input type="text" name="siteNom" disabled="disabled" value="${site.nom}" required
                           class="form-control"
                           aria-label="siteNom"
                           aria-describedby="siteNom">
                </div>
                <div class="input-group col-lg">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="secteurNom">Nom du secteur : </span>
                    </div>
                    <input type="text" name="secteurNom" required class="form-control" aria-label="secteurNom"
                           aria-describedby="secteurNom">
                </div>
                <div class="row col-lg-12 no-gutters">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="description">Description : </span>
                        </div>
                        <textarea class="form-control" name="description" aria-label="With textarea"></textarea>
                    </div>
                </div>
            </div>
            <br><br>
            <div class="text-right">
                <button type="submit" class="btn btn-primary">Ajouter</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
