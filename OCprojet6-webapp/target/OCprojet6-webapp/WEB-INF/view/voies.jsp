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
    <link rel="stylesheet"
          href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

    <title>Page des voies</title>
</head>

<%@include file="header.jsp" %>

<div id="body">
    <div class="container">
        <div class="card">
            <div class="card-header" id="voieCardHeader">
                <h2 class="card-title">${secteur.nom}</h2>
                <div class="text-right">
                    <c:url var="showSecteurPage" value="/showSecteurPage">
                        <c:param name="siteId" value="${siteId}"/>
                    </c:url>
                    <a href="${showSecteurPage}" type="button" id="btnRetour" class="btn btn-warning">Retour aux
                        secteurs</a>
                </div>
                <div>
                    <c:if test="${ !empty messageCreationVoie}">
                        <div class="alert alert-success" role="alert">
                            <c:out value="${messageCreationVoie}"/>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="card-body">
                <table class="table" id="infoVoies">
                    <thead>
                    <tr>
                        <th>Nom:</th>
                        <th>Hauteur:</th>
                        <th>Cotation:</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="voie" items="${voies}">
                        <tr>
                            <td>${voie.nom}</td>
                            <td>${voie.hauteur}</td>
                            <td>${voie.cotation.valeur}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
                <div class="text-right">
                    <c:url var="creationVoieForm" value="/showCreationVoieForm">
                        <c:param name="secteurId" value="${secteur.id}"/>
                        <c:param name="siteId" value="${siteId}"/>
                    </c:url>
                    <a href="${creationVoieForm}" type="button" id="btnAjoutVoie" class="btn btn-warning">Ajouter
                        une voie</a>
                </div>
            </sec:authorize>
        </div>
    </div>
</div>


<!-- FOOTER -->
<footer id="footer" class="page-footer">
    <p class="float-right"><a href="#">Back to top</a></p>
    <p>&copy; 2020 - Les amis de l'escalade &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a>
    </p>
</footer>


<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script rel="script" src="${pageContext.request.contextPath}/resources/js/webappJsFunctions.js"></script>

</html>
