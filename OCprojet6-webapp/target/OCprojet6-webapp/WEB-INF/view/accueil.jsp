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
<div class="container">
    <form action="searchSite" method="post">
        <div class="row">
            <div class="input-group col-sm">
                <select class="custom-select" name="sites" id="sites">
                    <option selected disabled>Site</option>
                </select>
            </div>
            <div class="input-group col-sm">
                <select class="custom-select" name="regions" id="regions">
                    <option selected disabled>Région</option>
                    <c:forEach var="region" items="${regions}">
                        <option value="${region.nom}">${region.nom}</option>
                    </c:forEach>
                </select>
            </div>
<%--            DEBUG DEPARTEMENT RM => TEST REGION BY ID OK!--%>
<%--            <div class="input-group col-sm">--%>
<%--                <select class="custom-select" name="region" id="region">--%>
<%--                    <option selected disabled>Debug</option>--%>
<%--                        <option value="${region.nom}">${region.nom}</option>--%>
<%--                </select>--%>
<%--            </div>--%>
            <div class="input-group col-sm">
                <select class="custom-select" name="departements" id="departements">
                    <option selected disabled>Département</option>
                    <c:forEach var="departement" items="${departements}">
                        <option value="${departement.nom}">${departement.nom}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group col-sm">
                <select class="custom-select" name="villes" id="villes">
                    <option selected disabled>Villes</option>
                    <c:forEach var="ville" items="${villes}">
                        <option value="${ville.nom}">${ville.nom}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group col-sm">
                <select class="custom-select" name="nbSecteurs" id="nbSecteurs">
                    <option selected disabled>Nombre de secteurs</option>
                </select>
            </div>
            <div class="input-group col-sm">
                <select class="custom-select" name="nbVoies" id="nbVoies">
                    <option selected disabled>Nombre de voies</option>
                </select>
            </div>

            <div class="col-sm-1 offset-10 ">
                <button type="submit" class="btn btn-primary">Rechercher</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
