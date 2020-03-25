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
                    <c:if test="${!empty message_succes}">
                        <div class="alert alert-success" role="alert">
                            <c:out value="${message_succes}"/>
                        </div>
                    </c:if>
                    <c:if test="${!empty message_alert}">
                        <div class="alert alert-danger" role="alert">
                            <c:out value="${message_alert}"/>
                        </div>
                    </c:if>
                </div>
            </div>
            <div class="card-body">
                <c:if test="${ !empty secteurss}">
                <c:forEach var="secteur" items="${secteurss}">
                <div class="card" id="secteurCard">
                    <div class="card-header" id="secteurCardHeader">
                        <div class="row">
                            <div class="col">
                                <h2 class="card-title">${secteur.nom}</h2>
                            </div>
                            <sec:authorize access="hasAnyRole({'ROLE_USER', 'ROLE_ADMIN'})">
                                <c:url var="modifierSecteur" value="/showSecteurForm">
                                    <c:param name="secteurId" value="${secteur.id}"/>
                                    <c:param name="siteId" value="${site.id}"/>
                                </c:url>
                                <div class="col-auto pull-right">
                                    <a class="btn btn-warning" href="${modifierSecteur}">Modifier</a>
                                </div>
                            </sec:authorize>
                        </div>
                    </div>
                    <div class="card-body">
                        <table class="table" id="infoSecteur">
                            <tr>
                                <th>Nombre de voies : ${secteur.nbDeVoies}</th>
                                <th>Hauteur max : ${secteur.hauteurMax} m</th>
                                <th>Cotation : de ${secteur.cotationMinMax[0]}
                                    à ${secteur.cotationMinMax[1]}</th>
                            </tr>
                        </table>
                        <div id="descriptionBlock">
                            <p>Description :</p>
                            <div id="descriptionText">
                                    ${secteur.description}
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="btn-toolbar" role="toolbar">
                            <div class="btn-group ml-auto" role="group">
                                <c:url var="showVoiePage" value="/showVoiePage">
                                    <c:param name="secteurId" value="${secteur.id}"/>
                                    <c:param name="siteId" value="${site.id}"/>
                                </c:url>
                                <a href="${showVoiePage}" type="button" class="btn btn-warning">Voir les
                                    voies</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </c:forEach>
            </c:if>
        </div>
        <sec:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')">
            <div class="text-left">
                <c:url var="ajouterSecteur" value="/showSecteurForm">
                    <c:param name="siteId" value="${site.id}"/>
                </c:url>
                <a href="${ajouterSecteur}" type="button" id="btnAjoutSecteur" class="btn btn-warning">Ajouter
                    un secteur</a>
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
