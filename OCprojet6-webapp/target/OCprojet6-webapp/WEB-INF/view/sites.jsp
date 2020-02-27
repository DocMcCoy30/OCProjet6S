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
    <div class="container">
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
                        <h2 class="card-title">${site.nom}</h2>
                    </div>
                    <c:url var="modifierSite" value="/showCreationSiteForm">
                        <c:param name="siteId" value="${site.id}"/>
                    </c:url>
                    <div class="col-auto pull-right">
                        <a class="btn btn-warning" href="${modifierSite}">Modifier</a>
                    </div>
                </div>
                <h5 class="text-muted text-right">${site.ville.nom} - ${site.departement.nom}</h5>
            </div>
        </div>
        <div class="card-body" id="siteCardBody">
            <div>
                <img id="banniereSite" src="${pageContext.request.contextPath}/resources/img/${site.listPhotos[0].nom}"
                     class="card-img-top" alt="${site.listPhotos[0].nom}">
            </div>
            <div id="descriptionBlock">
                <p>Description :</p>
                <div id="descriptionText">
                    ${site.description.description}
                </div>
            </div>
        </div>
        <div class="card-footer" id="siteCardFooter">
            <c:url var="secteurPage" value="/showSecteurPage">
                <c:param name="siteId" value="${site.id}"/>
            </c:url>
            <div class="btn-toolbar mx-auto" role="toolbar" id="buttonLinkBar">
                <div class="btn-group col-auto mr-2" role="group">
                    <a class="btn btn-warning" href="${secteurPage}">Voir les secteurs</a>
                </div>
                <div class="btn-group col-auto mr-2" role="group">
                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/#">Voir les topos</a>
                </div>
<%--                <div class="btn-group col-auto mr-2" role="group">--%>
<%--                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/#">Ajouter un topo</a>--%>
<%--                </div>--%>
                <div class="btn-group col-auto mr-2" role="group">
                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/#">Voir les photos</a>
                </div>
<%--                <div class="btn-group col-auto mr-2" role="group">--%>
<%--                    <input class="btn btn-warning" type="submit" onclick="showFormUpload(1)"--%>
<%--                           value="Ajouter une photo"><br/>--%>
<%--                </div>--%>
                <div class="btn-group col-auto mr-2" role="group">
                    <a class="btn btn-warning" href="${pageContext.request.contextPath}/#">Enregistrer</a>
                </div>
            </div>
            <br>
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
            <div>
                <c:if test="${ !empty uploadMsg}">
                    <div class="alert alert-success" role="alert">
                        <c:out value="${uploadMsg}"/>
                    </div>
                </c:if>
            </div>
        </div>
        <br><br>
        <div class="card">
            <div class="card-header">
                <h2 class="card-title">Commentaires</h2>
            </div>
            <div class="card-body">
                <ul class="list-unstyled">
                    <li class="media">
                        <img src="..." class="mr-3" alt="...">
                        <div class="media-body">
                            <h5 class="mt-0 mb-1">titre commentaire</h5>
                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
                            sollicitudin.
                            Cras
                            purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
                            nisi
                            vulputate fringilla. Donec lacinia congue felis in faucibus.
                        </div>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <button type="button" class="btn btn-outline-warning">Modifier</button>
                            <button type="button" class="btn btn-outline-warning">Supprimer</button>
                        </sec:authorize>
                    </li>
                    <li class="media">
                        <img src="..." class="mr-3" alt="...">
                        <div class="media-body">
                            <h5 class="mt-0 mb-1">titre commentaire</h5>
                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
                            sollicitudin.
                            Cras
                            purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
                            nisi
                            vulputate fringilla. Donec lacinia congue felis in faucibus.
                        </div>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <button type="button" class="btn btn-outline-warning">Modifier</button>
                            <button type="button" class="btn btn-outline-warning">Supprimer</button>
                        </sec:authorize>
                    </li>
                    <li class="media">
                        <img src="..." class="mr-3" alt="...">
                        <div class="media-body">
                            <h5 class="mt-0 mb-1">titre commentaire</h5>
                            Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante
                            sollicitudin.
                            Cras
                            purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac
                            nisi
                            vulputate fringilla. Donec lacinia congue felis in faucibus.
                        </div>
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <button type="button" class="btn btn-outline-warning">Modifier</button>
                            <button type="button" class="btn btn-outline-warning">Supprimer</button>
                        </sec:authorize>
                    </li>
                </ul>
                <sec:authorize access="hasAnyRole({'ROLE_USER', 'ROLE_ADMIN'})">
                    <div class="text-right">
                        <button type="button" id="btnAjoutCommentaire" class="btn btn-outline-primary">Ajouter un
                            commentaire
                        </button>
                    </div>
                </sec:authorize>
            </div>
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
