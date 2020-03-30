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

    <title>Page de creation de secteur</title>
</head>

<%@include file="header.jsp" %>

<div id="body">
    <div class="container">
        <c:set var="site" value="${site}"/>
        <div class="card">
            <div class="card-header">
                <c:url var="secteurPage" value="/showSecteurPage">
                    <c:param name="siteId" value="${site.id}"/>
                </c:url>
                <input id="secteurId" name="secteurId" type="hidden" value="${secteur.id}">
                <h2 class="card-title"><a href="${secteurPage}">${site.nom}</a></h2>
            </div>
            <div class="card-body">
                <h5>Ajouter/modifier un secteur :</h5>
                <form action="createUpdateSecteur" method="post">
                    <div class="row col-md-12 no-gutters">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="secteurNom">Nom du secteur : </span>
                            </div>
                            <c:choose>
                                <c:when test="${! empty secteur}">
                                    <input type="text" name="secteurNom" class="form-control" aria-label="secteurNom"
                                           aria-describedby="Nom du secteur" value="${secteur.nom}" required>
                                </c:when>
                                <c:otherwise>
                                    <input type="text" name="secteurNom" class="form-control" aria-label="secteurNom"
                                           aria-describedby="Nom du secteur" required>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <div class="row col-md-12 no-gutters">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="description">Description : </span>
                            </div>
                            <c:choose>
                                <c:when test="${! empty secteur}">
                                    <textarea class="form-control" name="description" aria-label="With textarea"
                                              aria-describedby="Description du secteur">
                                            ${secteur.description}</textarea>
                                </c:when>
                                <c:otherwise>
                                    <textarea class="form-control" name="description" aria-label="With textarea"
                                              aria-describedby="Description du secteur"></textarea>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <br><br>
                    <c:choose>
                        <c:when test="${! empty secteur}">
                            <div class="text-right">
                                <input hidden name="siteId" value="${site.id}">
                                <input hidden name="secteurId" value="${secteur.id}">
                                <button type="submit" class="btn btn-warning" name="action" value="update"
                                        id="btnModificationSecteur">Modifier
                                </button>
                            </div>
                        </c:when>
                        <c:otherwise>
                            <div class="text-right">
                                <input hidden name="siteId" value="${site.id}">
                                <button type="submit" class="btn btn-warning" name="action" value="create"
                                        id="btnCreationSecteur">Ajouter
                                </button>
                            </div>
                        </c:otherwise>
                    </c:choose>
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

