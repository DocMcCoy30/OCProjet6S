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

    <title>Page des secteurs</title>
</head>

<%@include file="header.jsp" %>

<div id="body">
    <div class="container">

        <div class="card">
            <div class="card-header">
                <c:url var="sitePage" value="/showSitePage">
                    <c:param name="siteId" value="${site.id}"/>
                </c:url>
                <form method="post" action="/searchSite">
                    <h2 class="card-title"><a href="${sitePage}">${site.nom}</a></h2>
                    <h5 class="text-muted text-right">${site.ville.nom} - ${site.departement.nom}</h5>
                </form>
                <div>
                    <c:if test="${ !empty messageCreationSecteur}">
                        <div class="alert alert-success" role="alert">
                            <c:out value="${messageCreationSecteur}"/>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="card-body">
                <c:if test="${ !empty listSecteurs}">
                    <c:forEach var="secteur" items="${listSecteurs}">
                        <div class="card" id="secteurCard">
                            <div class="card-header" id="secteurCardHeader">
                                <h2 class="card-title">${secteur.nom}</h2>
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <div>
                                        <c:url var="showVoiePage" value="/showVoiePage">
                                            <c:param name="secteurId" value="${secteur.id}"/>
                                            <c:param name="siteId" value="${site.id}"/>
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
                                <table class="table" id="infoSecteur">
                                    <thead>
                                    <tr>
                                        <th>Nombre de voies : ${secteur.nbDeVoies}</th>
                                        <th>Hauteur max : ${secteur.hauteurMax}</th>
                                        <th>Cotation : de ${secteur.cotationMinMax[0]}
                                            à ${secteur.cotationMinMax[1]}</th>
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
                    </c:forEach>
                </c:if>
            </div>
        </div>


        <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
            <div class="text-right">
                <c:url var="creationSecteurForm" value="/showCreationSecteurForm">
                    <c:param name="siteId" value="${site.id}"/>
                </c:url>
                <a href="${creationSecteurForm}" type="button" id="btnAjoutSecteur" class="btn btn-outline-warning">Ajouter
                    un secteur</a>
            </div>
        </sec:authorize>
    </div>
    <br><br>
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
