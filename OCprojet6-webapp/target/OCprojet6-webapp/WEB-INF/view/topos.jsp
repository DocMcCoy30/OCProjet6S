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

    <title>Page des topos</title>
</head>

<%@include file="header.jsp" %>

<div id="body">
    <div class="container">
        <div>
            <c:if test="${ !empty messageSuccess}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${messageSuccess}"/>
                </div>
            </c:if>
            <c:if test="${ !empty messageAlert}">
                <div class="alert alert-danger" role="alert">
                    <c:out value="${messageAlert}"/>
                </div>
            </c:if>
        </div>
    </div>
    <div class="container-fluid">
        <div class="card">
            <div class="card-header">
                <c:url var="sitePage" value="/showSitePage">
                    <c:param name="siteId" value="${site.id}"/>
                </c:url>
                <h2 class="card-title">Liste des topos du site <a href="${sitePage}">${site.nom}</a></h2>
            </div>
            <div class="card-body>">
                <form action="reserveTopo" method="post">
                    <table class="table" id="topoTable">
                        <thead>
                        <tr>
                            <th>Nom</th>
                            <th>Date de parution</th>
                            <th>Description</th>
                            <th>Réservé le :</th>
                            <th>Réserver pour le :</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <input type="hidden" name="username"
                               value="${pageContext.request.userPrincipal.name}">
                        <c:forEach var="topo" items="${topos}">
                            <input type="hidden" name="siteId" value="${site.id}">
                            <tr>
                                <td>${topo.nom}</td>
                                <td>${topo.dateParution}</td>
                                <td>${topo.description}</td>
                                <td>
                                    <div class="dropdown">
                                        <button class="btn btn-secondary dropdown-toggle" type="button"
                                                id="btnDatesReservees" data-toggle="dropdown" aria-haspopup="true"
                                                aria-expanded="false">
                                            Dates réservées
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <c:forEach var="reservation" items="${topo.listReservations}">
                                                <a class="dropdown-item">${reservation.dateReservation}</a>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </td>
                                <td><input type="date" name="dateReservation"></td>
                                <sec:authorize access="hasAnyRole({'ROLE_USER', 'ROLE_ADMIN'})">
                                    <td>
                                        <button type="submit" name="reservationTopoId" value="${topo.id}"
                                                class="btn btn-warning" id="btnReservationTopo">
                                            Reserver
                                        </button>
                                    </td>
                                </sec:authorize>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </form>
                <div class="card-footer">
                    <sec:authorize access="hasAnyRole({'ROLE_USER', 'ROLE_ADMIN'})">
                        <div class="text-right">
                            <input hidden name="siteId" value="${site.id}">
                            <button type="button" class="btn btn-warning"
                                    id="btnCreationSecteur" onclick="showTopoForm(1)">Ajouter un topo
                            </button>
                        </div>
                    </sec:authorize>
                </div>
            </div>
        </div>
        <div class="container">
            <form action="createTopo" method="post">
                <div class="card" id="topoForm">
                    <div class="card-header">
                        <input id="secteurId" name="secteurId" type="hidden" value="${secteur.id}">
                        <h2 class="card-title">Créer un topo pour le site ${site.nom}</h2>
                    </div>
                    <div class="card-body">
                        <h5>Ajouter un topo :</h5>
                        <div class="row col-md-12 no-gutters">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="topoNom">Nom du topo : </span>
                                </div>
                                <input type="text" name="topoNom" class="form-control" aria-label="topoNom"
                                       aria-describedby="Nom du Topo" required>
                            </div>
                        </div>
                        <div class="row col-md-12 no-gutters">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="dateParution">Date de parution :</span>
                                </div>
                                <input type="text" name="dateParution" class="form-control" aria-label="dateParution"
                                       aria-describedby="Date de parution" required>
                            </div>
                        </div>
                        <div class="row col-md-12 no-gutters">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Description :</span>
                                </div>
                                <textarea class="form-control" name="description" aria-label="description"
                                          aria-describedby="Description du topo" maxlength="200"></textarea>
                            </div>
                        </div>
                    </div>
                    <div class="card-footer">
                        <div class="text-right">
                            <input type="hidden" name="siteId" value="${site.id}">
                            <input type="hidden" name="username" value="${pageContext.request.userPrincipal.name}">
                            <button type="submit" class="btn btn-warning" id="btnAjoutTopo"
                                    onclick="showTopoForm(0)">
                                Ajouter
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
    </form>
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
