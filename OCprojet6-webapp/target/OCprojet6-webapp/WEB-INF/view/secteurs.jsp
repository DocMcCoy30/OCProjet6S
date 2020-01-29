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
                            <div class="text-right">
                                <c:url var="showVoiePage" value="/showVoiePage">
                                    <c:param name="secteurId" value="${secteur.id}"/>
                                </c:url>
                                <a href="${showVoiePage}" type="button" class="btn btn-outline-primary">Voir les voies</a>
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
                <a href="${creationSecteurForm}" type="button" class="btn btn-primary">Créer un secteur</a>
            </div>
        </sec:authorize>
    </div>
    <br><br>
</div>
</div>
</div>

</body>
</html>
