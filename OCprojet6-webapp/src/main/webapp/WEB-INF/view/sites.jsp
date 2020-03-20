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

    <title>Page des sites</title>
</head>

<%@include file="header.jsp" %>

<div id="body">
    <div class="container" id="site-container">
        <div>
            <c:if test="${ !empty message}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${message}"/>
                </div>
            </c:if>
        </div>
        <div class="card" id="siteCard">
            <div class="card-header" id="siteCardHeader">
                <div class="row">
                    <div class="col">
                        <%--                        <div class="row">--%>
                        <h2 class="card-title col-md-5">${site.nom}</h2>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <div class="col-md-3">
                                <c:if test="${site.officiel}">
                                    <input type="checkbox" name="siteId" value="${site.id}" id="officiel" checked/>
                                </c:if>
                                <c:if test="${! site.officiel}">
                                    <input type="checkbox" name="siteId" value="${site.id}" id="officiel"/>
                                </c:if>
                                <label class="form-check-label" for="officiel">
                                    <h5>Site Officiel</h5>
                                </label>
                            </div>
                        </sec:authorize>
                    </div>
                    <%--                    </div>--%>
                    <sec:authorize access="hasAnyRole({'ROLE_USER', 'ROLE_ADMIN'})">
                        <c:url var="modifierSite" value="/showSiteForm">
                            <c:param name="siteId" value="${site.id}"/>
                        </c:url>
                        <div class="col-auto pull-right">
                            <a class="btn btn-warning" href="${modifierSite}">Modifier</a>
                        </div>
                    </sec:authorize>
                </div>
                <h5 class="text-muted text-right">${site.ville.nom} - ${site.departement.nom}</h5>
            </div>
        </div>
        <div class="card-body" id="siteCardBody">
            <div class="form-inline">
                <input type="hidden" name="macaron-officiel" value="${site.officiel}" id="var-macaron">
                <%--                <img id="banniereSite" src="${pageContext.request.contextPath}/resources/img/${site.listPhotos[0].nom}"--%>
                <%--                     class="rounded" alt="${site.listPhotos[0].nom}">--%>
                <div id="carouselAccueil" class="carousel slide carousel-fade" data-ride="carousel">
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img id="photo-site"
                                 src="${pageContext.request.contextPath}/resources/img/${site.listPhotos[0].nom}"
                                 class="rounded" alt="${site.listPhotos[0].nom}">
                        </div>
                        <c:if test="${ ! empty site.listPhotos}">
                            <c:forEach var="photo" items="${site.listPhotos}">
                                <div class="carousel-item">
                                    <img id="photo-site-carousel"
                                         src="${pageContext.request.contextPath}/resources/img/${photo.nom}"
                                         class="rounded d-block w-100" alt="${photo.nom}">
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
                <img src="${pageContext.request.contextPath}/resources/img/Logo_Les_amis_de_l_escalade.png"
                     class="rounded mx-auto" alt="macaron-officiel" id="attribut-officiel">
                <%--                <span class="offset-2" id="attribut-officiel">Site officiel Les Amis de l'Escalade</span>--%>
            </div>
            <div id="descriptionBlock">
                <p>Description :</p>
                <div id="descriptionText">
                    ${site.description.description}
                </div>
            </div>
        </div>
        <div class="card-footer" id="siteCardFooter">
            <div class="btn-toolbar" role="toolbar" id="buttonLinkBar">
                <c:url var="secteurPage" value="/showSecteurPage">
                    <c:param name="siteId" value="${site.id}"/>
                </c:url>
                <div class="btn-group mx-auto" role="group">
                    <a class="btn btn-warning" href="${secteurPage}">Voir les secteurs</a>
                </div>
                <div class="btn-group mx-auto" role="group">
                    <c:url var="topoPage" value="/showTopoPage">
                        <c:param name="siteId" value="${site.id}"/>
                    </c:url>
                    <a class="btn btn-warning" href="${topoPage}">Voir les topos</a>
                </div>
                <div class="btn-group mx-auto" role="group">
                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/#">Voir les photos</a>
                </div>
                <div class="btn-group mx-auto" role="group">
                    <input class="btn btn-warning" type="submit" onclick="showFormUpload(1)"
                           value="Ajouter une photo"><br/>
                </div>
                <div class="btn-group mx-auto" role="group">
                    <input class="btn btn-warning" type="submit" onclick="showCommentPanel(1)"
                           value="Commentaires"><br/>
                </div>
                <div class="btn-group mx-auto" role="group">
                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/#">Enregistrer</a>
                </div>
            </div>
            <div>
                <c:if test="${ !empty message_succes}">
                    <div class="alert alert-success" role="alert">
                        <c:out value="${message_succes}"/>
                    </div>
                </c:if>
                <c:if test="${ !empty message_alert}">
                    <div class="alert alert-danger" role="alert">
                        <c:out value="${message_alert}"/>
                    </div>
                </c:if>
            </div>
            <form class="row" method="POST" action="uploadFile" id="formUpload" enctype="multipart/form-data">
                <input type="hidden" value="${site.id}" name="siteId">
                <div class="row col-md-12 no-gutters">
                    <div class="input-group col-md-7">
                        <div class="input-group-prepend">
                            <span class="input-group-text" id="inputGroupFileAddon">Image</span>
                        </div>
                        <div class="custom-file">
                            <input type="file" class="custom-file-input" name="file " id="inputGroupFile"
                                   aria-describedby="inputGroupFileAddon">
                            <label class="custom-file-label" for="inputGroupFile">Choisir une image</label>
                        </div>
                    </div>
                    <div class="input-group col-md-5">
                        <div class="input-group-prepend offset-1">
                            <span class="input-group-text form-control" id="nameLabel">Nom : </span>
                        </div>
                        <input type="text" class="form-control" name="nomPhoto" aria-label="nomPhoto"
                               aria-describedby="nameLabel">
                    </div>
                    <button class="btn btn-warning offset-10" id="btnUpload" type="submit"
                            onclick="showFormUpload(0)">Ajouter
                    </button>
                </div>
            </form>
            <br>
        </div>
        <br><br>
        <div class="card" id="commentaire-card">
            <div class="card-header">
                <h2 class="card-title">Commentaires</h2>
            </div>
            <div class="card-body">
                <form action="updateCommentaire" method="post">
                    <input type="hidden" name="page" value="page-site">
                    <ul class="list-unstyled">
                        <c:if test="${empty site.listCommentaires}">
                            <h5 style="color: red">Il n'y a aucun commentaire enregistré pour ce site.</h5>
                        </c:if>
                        <c:if test="${! empty site.listCommentaires}">
                            <c:forEach var="commentaire" items="${site.listCommentaires}">
                                <input type="hidden" name="siteId" value="${site.id}">
                                <input type="hidden" name="commentaireId" value="${commentaire.id}">
                                <li class="media">
                                    <div class="media-body" id="commentaire-div">
                                    <span style="color: brown; font-size: larger">
                                        Posté par ${commentaire.users.username} le ${commentaire.date}
                                    </span>
                                        <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                                            <div>
                                                <textarea class="col-md-12" name="commentaire">${commentaire.commentaire}</textarea>
                                            </div>
                                        </c:if>
                                        <c:if test="${!pageContext.request.isUserInRole('ROLE_ADMIN')}">
                                            <div>${commentaire.commentaire}</div>
                                        </c:if>
                                    </div>
                                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                                        <div id="adminCommentBtn">
                                            <button type="submit" class="btn btn-warning" name="action" value="update"
                                            >Modifier
                                            </button>
                                            <button type="submit" class="btn btn-warning" name="action" value="delete"
                                            >Supprimer
                                            </button>
                                        </div>
                                    </sec:authorize>
                                </li>
                            </c:forEach>
                        </c:if>
                    </ul>
                </form>
                <sec:authorize access="hasAnyRole({'ROLE_USER', 'ROLE_ADMIN'})">
                    <div class="text-right">
                        <button type="button" id="btnAjoutCommentaire" class="btn btn-primary"
                                onclick="showCommentaireForm(1)">
                            Ajouter un commentaire
                        </button>
                    </div>
                </sec:authorize>
            </div>
        </div>
        <form action="createCommentaire" method="post">
            <div class="card" id="commentaire-form">
                <div class="card-header">
                    <input id="siteId" name="siteId" type="hidden" value="${site.id}">
                    <h2 class="card-title">Ajouter un commentaire pour le site ${site.nom}</h2>
                </div>
                <div class="card-body">
                    <div class="row no-gutters">
                        <%--                        <div class="input-group">--%>
                        <%--                            <div class="input-group-prepend">--%>
                        <%--                                <span class="input-group-text" id="commentaireTitre">Titre : </span>--%>
                        <%--                            </div>--%>
                        <%--                            <input type="text" name="commentaireTitre" class="form-control"--%>
                        <%--                                   aria-label="commentaireTitre"--%>
                        <%--                                   aria-describedby="Titre du commentaire" required>--%>
                        <%--                        </div>--%>
                        <div class="input-group">
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">Commentaire : </span>
                                </div>
                                <textarea class="form-control" name="commentaire"
                                          aria-label="With textarea"></textarea>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="text-right">
                        <input type="hidden" name="siteId" value="${site.id}">
                        <input type="hidden" name="username" value="${pageContext.request.userPrincipal.name}">
                        <button type="submit" class="btn btn-warning" id="btnCreerCommentaire"
                                onclick="showCommentaireForm(0)">
                            Ajouter
                        </button>
                    </div>
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
