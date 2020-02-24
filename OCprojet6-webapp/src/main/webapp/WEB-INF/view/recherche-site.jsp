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

    <title>Page de recherche de sites</title>
</head>

<%@include file="header.jsp" %>

<div id="body">
    <div class="container">
        <form action="searchSites" method="post" id="searchSitesForm">
            <div class="row col-lg-12 no-gutters" id="SearchSiteBar">
                <div class="input-group col-lg">
                    <select class="custom-select" name="site" id="site" onchange="searchSitePopulate(1)">
                        <option selected disabled>Site</option>
                        <c:forEach var="site" items="${sites}">
                            <option value="${site.id}">${site.nom}</option>
                        </c:forEach>
                    </select>
                </div>
                &nbsp
                <div class="input-group col-lg">
                    <select class="custom-select" name="region" id="region" onchange="searchSitePopulate(2)">
                        <option selected disabled>Région</option>
                        <c:forEach var="region" items="${regions}">
                            <option value="${region.id}" name="refId">${region.nom}</option>
                        </c:forEach>
                    </select>
                </div>
                &nbsp
                <div class="input-group col-lg">
                    <select class="custom-select" name="departement" id="departement" onchange="searchSitePopulate(3)">
                        <option selected disabled>Département</option>
                        <c:forEach var="departement" items="${departements}">
                            <option value="${departement.code}">${departement.nom}</option>
                        </c:forEach>
                    </select>
                </div>
                &nbsp
                <div class="input-group col-lg">
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
        <br><br>
       <%--        Afficher les résultats de recherche     --%>
        <div>
            <c:if test="${ !empty messageCreationSite}">
                <div class="alert alert-success" role="alert">
                    <c:out value="${messageCreationSite}"/>
                </div>
            </c:if>
        </div>
        <c:if test="${ !empty messageInfoRecherche }">
        <div id="infoDeRecherche" class="col-md-12">
            <h4><c:out value="${messageInfoRecherche}"/></h4>
        </div>
        </c:if>
        <div class="row">
            <c:if test="${ !empty listSites}">
                <c:forEach var="site" items="${listSites}">
                    <c:url var="sitePageLink" value="/showSitePage">
                        <c:param name="siteId" value="${site.id}"/>
                    </c:url>
                    <div class="col-lg-6">
                        <div class="card" id="searchSiteCard">
                            <div class="row no-gutters">
                                <div class="col-lg-4">
                                    <a href="${sitePageLink}"><img
                                            src="${pageContext.request.contextPath}/resources/img/${site.listPhotos[0].nom}"
                                            class="card-img" alt="${site.listPhotos[0].nom}"></a>
                                </div>
                                <div class="col-lg-8">
                                    <div class="card-body">
                                        <a href="${sitePageLink}"><h5 class="card-title">${site.nom}</h5></a>
                                        <p class="card-text">${site.description.info}</p>
                                        <p class="card-text"><small class="text-muted">${site.region.nom}
                                            - ${site.departement.nom}</small></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:if>
        </div>
        <sec:authorize access="hasAnyRole({'ROLE_USER', 'ROLE_ADMIN'})">
            <div class="text-right">
                <a href="${pageContext.request.contextPath}/showCreationSiteForm" type="button"
                   class="btn btn-warning" id="createSiteButton">Créer
                    un site</a>
            </div>
        </sec:authorize>
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
