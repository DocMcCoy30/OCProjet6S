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

    <title>Page de creation de site</title>
</head>

<%@include file="header.jsp" %>

<div id="body">
    <div class="container">
        <div class="card">
            <c:url var="sitePage" value="/showSitePage">
                <c:param name="siteId" value="${site.id}"/>
            </c:url>
            <div class="card-header">
                <c:choose>
                    <c:when test="${! empty site}">
                        <h2 class="card-title"><a href="${sitePage}">${site.nom}</a></h2>
                    </c:when>
                    <c:otherwise>
                        <h2 class="card-title">Ajouter un site</h2>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="card-body">
                <form action="createUpdateSite" method="post">
                    <div class="row col-md-12 no-gutters">
                        <div class="input-group col-lg-7">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="nom">Nom du site : </span>
                            </div>
                            <c:choose>
                                <c:when test="${! empty site}">
                                    <input type="text" name="nom" class="form-control" aria-label="nom"
                                           aria-describedby="nom" value="${site.nom}" required>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="nom" class="form-control" aria-label="nom"
                                           aria-describedby="nom" required>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="input-group col-md ml-2">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="typeRoches">Type de roche : </span>
                            </div>
                            <c:choose>
                                <c:when test="${! empty site}">
                                    <select class="custom-select" name="typeRoche" id="typeRoche" required>
                                        <option selected value="${site.typeRoche.id}">${site.typeRoche.nom}</option>
                                        <c:forEach var="typeRoche" items="${typeRoche}">
                                            <option value="${typeRoche.id}">${typeRoche.nom}</option>
                                        </c:forEach>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <select class="custom-select" name="typeRoche" id="typeRoche" required>
                                        <option selected disabled></option>
                                        <c:forEach var="typeRoche" items="${typeRoche}">
                                            <option value="${typeRoche.id}">${typeRoche.nom}</option>
                                        </c:forEach>
                                    </select>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row col-md-12 no-gutters">
                        <div class="input-group col-md">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="regions">Region :</span>
                            </div>
                            <c:choose>
                                <c:when test="${! empty site}">
                                    <select class="custom-select" name="region" id="region" required>
                                        <option selected value="${site.region.id}">${site.region.nom}</option>
                                        <c:forEach var="region" items="${regions}">
                                            <option value="${region.id}">${region.nom}</option>
                                        </c:forEach>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <select class="custom-select" name="region" id="region" required>
                                        <option selected disabled></option>
                                        <c:forEach var="region" items="${regions}">
                                            <option value="${region.id}">${region.nom}</option>
                                        </c:forEach>
                                    </select>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="input-group col-md ml-2">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="departements">Departement :</span>
                            </div>
                            <c:choose>
                                <c:when test="${! empty site}">
                                    <select class="custom-select" name="departement" id="departement" required>
                                        <option selected
                                                value="${site.departement.code}">${site.departement.nom}</option>
                                        <c:forEach var="departement" items="${departements}">
                                            <option value="${departement.code}">${departement.nom}</option>
                                        </c:forEach>
                                    </select>
                                </c:when>
                                <c:otherwise>
                                    <select class="custom-select" name="departement" id="departement" required>
                                        <option selected disabled></option>
                                        <c:forEach var="departement" items="${departements}">
                                            <option value="${departement.code}">${departement.nom}</option>
                                        </c:forEach>
                                    </select>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="input-group col-md ml-2">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="ville">Ville : </span>
                            </div>
                            <c:choose>
                                <c:when test="${! empty site}">
                                    <input type="text" name="ville" class="form-control" aria-label="ville"
                                           aria-describedby="ville" value="${site.ville.nom}" required>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="ville" class="form-control" aria-label="ville"
                                           aria-describedby="ville" required>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row col-lg-12 no-gutters">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Description : </span>
                            </div>
                            <c:choose>
                                <c:when test="${! empty site}">
                                    <textarea class="form-control" name="description"
                                              aria-label="With textarea">${site.description.description}</textarea>
                                </c:when>
                                <c:otherwise>
                                    <textarea class="form-control" name="description"
                                              aria-label="With textarea"></textarea>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="btn-toolbar" role="toolbar" id="buttonLinkBar">
                        <c:choose>
                            <c:when test="${! empty site}">
                                <div class="btn-group mx-auto" role="group">
                                    <input class="btn btn-warning" type="button" onclick="showFormUpload(1)"
                                           value="Ajouter une photo">
                                </div>
                                <div class="btn-group mx-auto" role="group">
                                    <input hidden name="siteId" value="${site.id}">
                                    <input hidden name="descriptionId" value="${site.description.id}">
                                    <input hidden name="villeId" value="${site.ville.id}">
                                    <button type="submit" class="btn btn-warning" name="action" value="update"
                                            id="btnModificationSite">Modifier
                                    </button>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="btn-group mx-auto" role="group">
                                    <button type="submit" class="btn btn-warning" name="action" value="create"
                                            id="btnAjoutSite">Ajouter
                                    </button>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </form>
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
