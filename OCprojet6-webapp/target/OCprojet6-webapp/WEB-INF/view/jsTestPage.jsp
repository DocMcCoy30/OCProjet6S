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

    <title>Accueil</title>
</head>

<%@include file="header.jsp" %>

    <div id="body">
        <div class="container">
            <form action="searchSites" method="post" id="searchSitesForm">
                <div class="row col-md-12 no-gutters" id="buttonSearchSiteBar">
                    <div class="input-group col-md">
                        <select class="custom-select" name="site" id="site" onchange="searchSitePopulate(1)">
                            <option selected disabled>Site</option>
                            <c:forEach var="site" items="${sites}">
                                <option value="${site.id}">${site.nom}</option>
                            </c:forEach>
                        </select>
                    </div>
                    &nbsp
                    <div class="input-group col-md">
                        <select class="custom-select" name="region" id="region" onchange="searchSitePopulate(2)">
                            <option selected disabled>Région</option>
                            <c:forEach var="region" items="${regions}">
                                <option value="${region.id}" name="refId">${region.nom}</option>
                            </c:forEach>
                        </select>
                    </div>
                    &nbsp
                    <div class="input-group col-md">
                        <select class="custom-select" name="departement" id="departement"
                                onchange="searchSitePopulate(3)">
                            <option selected disabled>Département</option>
                            <c:forEach var="departement" items="${departements}">
                                <option value="${departement.code}">${departement.nom}</option>
                            </c:forEach>
                        </select>
                    </div>
                    &nbsp
                    <div class="input-group col-md">
                        <select class="custom-select" name="ville" id="ville" onchange="searchSitePopulate(4)">
                            <option selected disabled>Villes</option>
                            <c:forEach var="ville" items="${villes}">
                                <option value="${ville.id}">${ville.nom}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <input type="hidden" id="optionRef" name="optionRef" value=""/>
                </div>
            </form>
            <br><br><br>
            <div class="card">
                <div class="card-title"><h2>Ajouter un nouveau site</h2></div>
                <form action="creationSiteC" method="post">
                    <div class="row col-md-12 no-gutters">
                        <div class="input-group col-lg-7">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="nom">Nom du site : </span>
                            </div>
                            <input type="text" name="nom" class="form-control" aria-label="nom"
                                   aria-describedby="nom" required>
                        </div>
                        <div class="input-group col-lg-5">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="typeRoches">Type de roche : </span>
                            </div>
                            <select class="custom-select" name="typeRoche" id="typeRoche" required>
                                <option selected disabled></option>
                                <c:forEach var="typeRoche" items="${typeRoche}">
                                    <option value="${typeRoche.id}">${typeRoche.nom}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="row col-md-12 no-gutters">
                        <div class="input-group col-lg">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="regions">Region :</span>
                            </div>
                            <select class="custom-select" name="region" id="regionC" required>
                                <option selected disabled></option>
                                <c:forEach var="region" items="${regions}">
                                    <option value="${region.id}">${region.nom}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="input-group col-lg">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="departements">Departement :</span>
                            </div>
                            <select class="custom-select" name="departement" required id="departementC">
                                <option selected disabled></option>
                                <c:forEach var="departement" items="${departements}">
                                    <option value="${departement.code}">${departement.nom}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="input-group col-lg">
                            <div class="input-group-prepend">
                                <span class="input-group-text" id="villeC">Ville : </span>
                            </div>
                            <input type="text" name="ville" class="form-control" aria-label="ville"
                                   aria-describedby="ville" required>
                        </div>
                    </div>
                    <div class="row col-lg-12 no-gutters">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">Description : </span>
                            </div>
                            <textarea class="form-control" name="description" aria-label="With textarea"></textarea>
                        </div>
                    </div>
                    <div class="text-right">
                        <button type="submit" class="btn btn-outline-warning" id="btnCreationSite">Ajouter</button>
                    </div>
                </form>
            </div>
            <br><br>
            <span id="resultat"></span>
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
<script rel="script" src="${pageContext.request.contextPath}/resources/js/labo.js"></script>

</html>
