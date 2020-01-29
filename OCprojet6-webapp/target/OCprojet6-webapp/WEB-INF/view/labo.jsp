<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Labo</title>
</head>
<body>
<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    <%--        <div class="navbar-nav">--%>
    <%--            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/accueil">Accueil<span--%>
    <%--                    class="sr-only">(current)</span></a>--%>
    <%--            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/sites">Sites</a>--%>
    <%--        </div>--%>
</div>
<table class="table">
    <thead>
    <tr>
        <th>Nom</th>
        <th>description</th>
        <th>type de roche</th>
        <th>region</th>
        <th>departement</th>
        <th>ville</th>
    </tr>
    </thead>
    <c:if test="${ !empty listeSitesSearchResult}">
        <tbody>

        <c:forEach var="result" items="${listeSitesSearchResult}">
            <tr>
                <td>${result.nom}</td>
                <td>${result.description}</td>
                <td>${result.typeRoche.nom}</td>
                <td>${result.region.nom}</td>
                <td>${result.departement.nom}</td>
                <td>${result.ville.nom}</td>
            </tr>
        </c:forEach>

        </tbody>
    </c:if>
    <iframe src="https://www.oblyk.org/iframe/crag/75" width="100%" height="150px" frameborder="0"></iframe>

</table>
<br><br>

</body>
</html>
