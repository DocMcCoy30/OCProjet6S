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
    <form action="searchSites" method="post">
        <div class="row col-md-12 no-gutters">
            <div class="input-group col-md">
                <select class="custom-select" name="site" id="site">
                    <option selected disabled>Site</option>
                    <c:forEach var="site" items="${sites}">
                        <option value="${site.id}">${site.nom}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group col-md">
                <select class="custom-select" name="region" id="region">
                    <option selected disabled>Région</option>
                    <c:forEach var="region" items="${regions}">
                        <option value="${region.id}">${region.nom}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group col-md">
                <select class="custom-select" name="departement" id="departement">
                    <option selected disabled>Département</option>
                    <c:forEach var="departement" items="${departements}">
                        <option value="${departement.code}">${departement.nom}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="input-group col-md">
                <select class="custom-select" name="ville" id="ville">
                    <option selected disabled>Villes</option>
                    <c:forEach var="ville" items="${villes}">
                        <option value="${ville.id}">${ville.nom}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="text-right">
            <button type="submit" class="btn btn-primary">Rechercher</button>
        </div>
    </form>
    <br><br>
    <a href="${pageContext.request.contextPath}/caracteristique/liste">caracteristiques / ADMIN TEST</a>
    <br><br>

    <%--        Afficher les résultats de recherche     --%>
    <div>
        <c:if test="${ !empty messageCreationSite}">
            <div class="alert alert-success" role="alert">
                <c:out value="${messageCreationSite}"/>
            </div>
        </c:if>
    </div>
    <div class="row">
        <c:if test="${ !empty listSites}">
            <c:forEach var="result" items="${listSites}">
                <c:url var="sitePageLink" value="/showSitePage">
                    <c:param name="siteId" value="${result.id}"/>
                </c:url>
                <div class="col-sm-6">
                    <div class="card">
                        <div class="row no-gutters">
                            <div class="col-md-4">
                                <a href="#"><img src="..." class="card-img" alt="..."></a>
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <a href="${sitePageLink}"><h5 class="card-title">${result.nom}</h5></a>
                                    <p class="card-text">${result.description.info}</p>
                                    <p class="card-text"><small class="text-muted">${result.region.nom}
                                        - ${result.departement.nom}</small></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
    </div>

    <%--        Afficher le message et le nouveau site     --%>
    <%--<c:if test="${ !empty messageCreationSite}">--%>
    <%--    <div class="alert alert-success" role="alert">--%>
    <%--    <c:out value="${messageCreationSite}"/>--%>
    <%--    </div>--%>
    <%--        <div>--%>
    <%--            <c:set var="newSite" scope="session" value="${newSite}"/>--%>
    <%--            <c:set var="description" scope="session" value="${description}"/>--%>
    <%--            <div class="col-sm-6">--%>
    <%--                <div class="card">--%>
    <%--                    <div class="card">--%>
    <%--                        <div class="row no-gutters">--%>
    <%--                            <div class="col-md-4">--%>
    <%--                                <a href="#"><img src="..." class="card-img" alt="..."></a>--%>
    <%--                            </div>--%>
    <%--                            <div class="col-md-8">--%>
    <%--                                <div class="card-body">--%>
    <%--                                    <a href="#"><h5 class="card-title"><c:out value="${newSite.nom}"/></h5></a>--%>
    <%--                                    <p class="card-text"><c:out value="${description}"/></p>--%>
    <%--                                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>--%>
    <%--                                </div>--%>
    <%--                            </div>--%>
    <%--                        </div>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </c:if>--%>
    <div class="text-right">
        <a href="${pageContext.request.contextPath}/showCreationSiteForm" type="button" class="btn btn-primary">Créer
            un site</a>
    </div>
</div>

</body>
</html>
