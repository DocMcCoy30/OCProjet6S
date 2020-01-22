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
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/accueil">Accueil<span
                    class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/sites">Sites</a>
        </div>
    </div>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
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
<div class="container">
    <div class="row">
        <div class="btn-group col-sm">
            <button type="button" class="btn btn-primary btn-lg dropdown-toggle"
                    data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Site
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
            </div>
        </div>
        <div class="btn-group col-sm">
            <button type="button" class="btn btn-primary btn-lg dropdown-toggle"
                    data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Region
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
            </div>
        </div>
        <div class="btn-group col-sm">
            <button type="button" class="btn btn-primary btn-lg dropdown-toggle"
                    data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Departement
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
            </div>
        </div>
        <div class="btn-group col-sm">
            <button type="button" class="btn btn-primary btn-lg dropdown-toggle"
                    data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Ville
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
            </div>
        </div>
        <div class="btn-group col-sm">
            <button type="button" class="btn btn-primary btn-lg dropdown-toggle"
                    data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Nb de secteurs
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
            </div>
        </div>
        <div class="btn-group col-sm">
            <button type="button" class="btn btn-primary btn-lg dropdown-toggle"
                    data-toggle="dropdown"
                    aria-haspopup="true" aria-expanded="false">
                Nb de voies
            </button>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#">Action</a>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>
