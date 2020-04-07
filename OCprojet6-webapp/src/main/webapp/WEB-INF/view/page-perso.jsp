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

    <title>Page Perso</title>
</head>

<%@include file="header.jsp" %>

<div id="body">
    <div class="container">

        <div id="connected-user-panel">
            <form action="updateUserMail" method="post">
                <input type="hidden" name="username" value="${connectedUser.username}">
                <h2>Données personnelles :</h2>
                <div class="row col-md-12 no-gutters">
                    <div class="input-group col-lg-7">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="nom">Username : </span>
                        </div>
                        <input type="text" name="username" class="form-control" aria-label="username"
                               aria-describedby="username" value="${connectedUser.username}" disabled>
                    </div>
                </div>
                <div class="row col-md-12 no-gutters">
                    <div class="input-group col-lg-7">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="email">Email : </span>
                        </div>
                        <input type="email" name="email" class="form-control" aria-label="email"
                               aria-describedby="email" value="${connectedUser.email}">
                    </div>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-warning" name="action"
                            value="updateEmail"
                    >Modifier
                    </button>
                </div>
            </form>
        </div>


        <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
        <form action="updateCommentaire" method="post">
            <input type="hidden" name="page" value="page-perso">
            <div id="commentaire-panel">
                <h2>Liste des commentaires à valider :</h2>
                <ul class="list-unstyled">
                    <c:if test="${empty commentaires}">
                        <h5 style="color: red">Il n'y a aucun commentaire à valider.</h5>
                    </c:if>
                    <c:if test="${! empty commentaires}">
                        <c:forEach var="commentaire" items="${commentaires}" varStatus="line">
                            <li class="media">
                                <div class="media-body" id="commentaire-div">
                                    <div class="row">
                                        <input type="hidden" value="${commentaire.id}" name="commentaireId">
                                        <input type="hidden" name="username"
                                               value="${pageContext.request.userPrincipal.name}">
                                        <div class="col" style="color: yellow; font-size: larger">
                                            Posté par ${commentaire.users.username} le ${commentaire.date}
                                        </div>
                                        <div class="form-check form-check-inline pull-right">
                                            <input class="form-check-input" type="checkbox" id="validation"
                                                   name="commentaireId"
                                                   value="${commentaire.id}">
                                            <label class="form-check-label" style="color: white"
                                                   for="validation">Publier</label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <textarea class=" col-md-12"
                                                  name="commentaire">${commentaire.commentaire}</textarea>
                                    </div>
                                    <button type="submit" class="btn btn-warning" name="action"
                                            value="${line.index},update,${commentaire.id}"
                                    >Modifier
                                    </button>
                                    <button type="submit" class="btn btn-warning" name="action"
                                            value="${line.index},delete,${commentaire.id}"
                                    >Supprimer
                                    </button>
                                </div>
                            </li>
                        </c:forEach>
                    </c:if>
                </ul>
                <div class="text-center">
                    <a href="${page_perso}" type="button"
                       class="btn btn-warning" id="btnRefresh">Rafraichir</a>
                </div>
            </div>
        </form>
        </c:if>

        <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
        <div id="user-panel">
            <h2>Listes des utilisateurs :</h2>
            <table class="table table-dark" id="userTable">
                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Utilisateur/Administrateur</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty users}">
                    <h5 style="color: red">Il n'y a aucun utilisateur.</h5>
                </c:if>
                <c:if test="${! empty users}">
                    <c:forEach var="user" items="${users}" varStatus="line">
                        <tr>
                            <td>${user.username}</td>
                            <td>${user.email}</td>
                            <td>${user.userRole}</td>
                            <td>
                                <div class="form-check form-check-inline">
                                    <c:if test="${user.userRole == 'ROLE_USER'}">
                                        <input class="form-check-input" type="radio" id="ROLE_USER"
                                               name="user_role${line.index}"
                                               value="${user.username}" checked>
                                        <label class="form-check-label" for="ROLE_USER">User</label>
                                    </c:if>
                                    <c:if test="${user.userRole != 'ROLE_USER'}">
                                        <input class="form-check-input" type="radio" id="ROLE_USER"
                                               name="user_role${line.index}"
                                               value="${user.username}" checked>
                                        <label class="form-check-label" for="ROLE_USER">User</label>
                                    </c:if>
                                    &nbsp&nbsp
                                    <c:if test="${user.userRole == 'ROLE_ADMIN'}">
                                        <input class="form-check-input" type="radio" id="ROLE_ADMIN"
                                               name="user_role${line.index}"
                                               value="${user.username}" checked>
                                        <label class="form-check-label" for="ROLE_ADMIN">Admin</label>
                                    </c:if>
                                    <c:if test="${user.userRole != 'ROLE_ADMIN'}">
                                        <input class="form-check-input" type="radio" id="ROLE_ADMIN"
                                               name="user_role${line.index}"
                                               value="${user.username}">
                                        <label class="form-check-label" for="ROLE_ADMIN">Admin</label>
                                    </c:if>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
        </c:if>

        <c:if test="${! empty topos}">
        <div id="topo-panel">
            <h2>Mes topos :</h2>
            <c:if test="${demande}">
                <h4 style="color: yellow">Vous avez des demandes de réservation en attente !</h4>
            </c:if>
            <table class="table table-bordered table-dark" id="topoPersoTable">
                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Date de parution</th>
                    <th>Réservation :</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="topo" items="${topos}">
                    <input type="hidden" name="siteId" value="${site.id}">
                    <tr>
                        <td>${topo.nom}</td>
                        <td>${topo.dateParution}</td>
                        <td>
                            <c:if test="${empty topo.listReservations}">
                                <span style="color: red">Aucune réservation pour ce topo</span>
                            </c:if>
                            <c:if test="${! empty topo.listReservations}">
                            <table class="table" id="topoResa">
                                <thead>
                                <tr>
                                    <th>Date réservée :</th>
                                    <th>par :</th>
                                    <th>email :</th>
                                    <th>statut :</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="reservation" items="${topo.listReservations}">
                                    <form method="post" action="annulerReservation">
                                        <tr>
                                            <td>${reservation.dateReservation}</td>
                                            <td>${reservation.user.username}</td>
                                            <td>${reservation.user.email}</td>
                                            <td>${reservation.statut.etat}</td>
                                            <td>
                                                <c:if test="${reservation.statut.id<3}">
                                                    <input type="hidden" name="username"
                                                           value="${pageContext.request.userPrincipal.name}">
                                                    <button type="submit" name="reservation-id"
                                                            value="${reservation.id}"
                                                            class="btn btn-warning" id="btnReservationTopo">
                                                        Annuler
                                                    </button>
                                                </c:if>
                                            </td>
                                        </tr>
                                    </form>
                                </c:forEach>
                                </tbody>
                            </table>
                        </td>
                        </c:if>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </c:if>

        <c:if test="${demande == true}">
        <div id="reservation-panel">
            <h2>Mes demandes de reservation en attente :</h2>
            <table class="table table-dark" id="demandeReservationTable">
                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Réservation demandée par :</th>
                    <th>Pour le :</th>
                    <th>email de contact :</th>
                    <td></td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="topo" items="${topos}">
                    <c:forEach var="reservation" items="${topo.listReservations}" varStatus="line">
                        <c:if test="${reservation.statut.id == 2}">
                            <tr>
                                <td>${topo.nom}</td>
                                <td>${reservation.user.username}</td>
                                <td>${reservation.dateReservation}</td>
                                <td>${reservation.user.email}</td>
                                <td>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" id="accepter"
                                               name="reservation${line.index}"
                                               value="${reservation.id}">
                                        <label class="form-check-label" for="accepter">accepter</label>
                                    </div>
                                    <div class="form-check form-check-inline">
                                        <input class="form-check-input" type="radio" id="refuser"
                                               name="reservation${line.index}"
                                               value="${reservation.id}">
                                        <label class="form-check-label" for="refuser">refuser</label>
                                    </div>
                                </td>
                            </tr>
                        </c:if>
                    </c:forEach>
                </c:forEach>
                </tbody>
            </table>
            <div class="text-center">
                <a href="${page_perso}" type="button"
                   class="btn btn-warning" id="btnRefreshResa">Valider mes choix</a>
            </div>
        </div>
        </c:if>

        <c:if test="${! empty mesReservations}">
        <div id="reservation-panel">
            <h2>Mes réservations :</h2>
            <table class="table table-bordered table-dark" id="topoReservationTable">
                <thead>
                <tr>
                    <th>Nom</th>
                    <th>Propriétaire :</th>
                    <th>Réservation :</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="maReservation" items="${mesReservations}">
                    <tr>
                        <td>${maReservation.topo.nom}</td>
                        <td>
                            <table class="table table-borderless">
                                <tr>
                                    <td>${maReservation.topo.user.username}</td>
                                    <td>${maReservation.topo.user.email}</td>
                                </tr>
                            </table>
                        </td>
                        <td>
                            <table class="table table-borderless">
                                <tr>
                                    <td>${maReservation.dateReservation}</td>
                                    <td>${maReservation.statut.etat}</td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        </c:if>

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
