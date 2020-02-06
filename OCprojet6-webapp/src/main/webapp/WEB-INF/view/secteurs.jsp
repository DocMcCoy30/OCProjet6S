<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<header>
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
        <a class="navbar-brand" href="${pageContext.request.contextPath}"><h2>Les amis de l'escalade</h2></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="${pageContext.request.contextPath}/accueil">Home<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/showSearchSitePage">Recherche</a>
                </li>
<%--                <li class="nav-item">--%>
<%--                    <a class="nav-link disabled" href="#">Disabled</a>--%>
<%--                </li>--%>
            </ul>
        </div>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a class="btn btn-outline-warning" href="${pageContext.request.contextPath}/signin">Creer un compte</a>
            &nbsp
            <a class="btn btn-outline-warning" href="${pageContext.request.contextPath}/login">Se connecter</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <div>Bonjour ${pageContext.request.userPrincipal.name}</div>
            &emsp;
            <form action="${logoutUrl}" method="post" id="logoutForm">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
                <a class="btn btn-outline-warning" href="javascript:formSubmit()">Se déconnecter</a>
            </form>
        </c:if>
    </nav>
</header>
<br><br>
<main role="main">
    <br><br>
    <div class="container">
        <div class="card">
            <div class="card-header">
                <h2 class="card-title">${site.nom}</h2><h5 class="text-muted text-right">${site.ville.nom}
                - ${site.departement.nom}</h5>
            </div>
            <div>
                <c:if test="${ !empty messageCreationSecteur}">
                    <div class="alert alert-success" role="alert">
                        <c:out value="${messageCreationSecteur}"/>
                    </div>
                </c:if>
            </div>
            <c:if test="${ !empty listSecteurs}">
                <c:forEach var="secteur" items="${listSecteurs}">
                    <div class="container">
                        <div class="card">
                            <div class="card-header">
                                <a href="#"><h3 class="card-title">${secteur.nom}</h3></a>
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <div>
                                        <c:url var="showVoiePage" value="/showVoiePage">
                                            <c:param name="secteurId" value="${secteur.id}"/>
                                        </c:url>
                                        <a href="${showVoiePage}" type="button" class="btn btn-outline-warning">Voir les
                                            voies</a>
                                    </div>
                                    &nbsp
                                    <div>
                                        <c:url var="showPhotoSecteurPage" value="/showPhotoSecteurPage">
                                            <c:param name="secteurId" value="${secteur.id}"/>
                                        </c:url>
                                        <a href="${showVoiePage}" type="button" class="btn btn-outline-warning">Voir les
                                            photos</a>
                                    </div>
                                </div>
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>Nombre de voies :</th>
                                        <th>Hauteur max :</th>
                                        <th>Cotation :</th>
                                    </tr>
                                    </thead>
                                </table>
                                <div>
                                    <img src="..." class="card-img-top" alt="...">
                                </div>
                                <div id="descriptionBlock">
                                    <p>Description :</p>
                                    <div id="descriptionText">
                                            ${secteur.description}
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>


            <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                <div class="text-right">
                    <c:url var="creationSecteurForm" value="/showCreationSecteurForm">
                        <c:param name="siteId" value="${site.id}"/>
                    </c:url>
                    <a href="${creationSecteurForm}" type="button" class="btn btn-outline-warning">Créer un secteur</a>
                </div>
            </sec:authorize>
        </div>
        <br><br>
    </div>

    <!-- FOOTER -->
    <footer id="footer" class="container">
        <p class="float-right"><a href="#">Back to top</a></p>
        <p>&copy; 2020 - Les amis de l'escalade &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a>
        </p>
    </footer>
</main>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script rel="script" src="${pageContext.request.contextPath}/resources/js/webappJsFunctions.js"></script>

</body>
</html>
