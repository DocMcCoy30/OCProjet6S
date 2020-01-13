<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <title>Liste des caracteristiques</title>
</head>
<body>

<div id="wrapper"class="col-md-10 col-offset-2">
    <div id="header">
            <h2>Caracteristiques</h2>
    </div>
</div>
<div id="container" class="col-md-10 col-offset-2">
    <div id="content">
        <input type="button" class="btn btn-primary" value="Ajout Caracteristique"
               onclick="window.location.href='formulaireAjout' ; return false;"
               class="add-button"
        />
        <table class="table">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Definition</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="tempCarac" items="${caracteristiques}">
                <c:url var="updateLink" value="/caracteristique/formulaireUpdate">
                    <c:param name="caracteristiqueId" value="${tempCarac.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/caracteristique/delete">
                    <c:param name="caracteristiqueId" value="${tempCarac.id}"/>
                </c:url>
                <tr>
                    <td>${tempCarac.nom}</td>
                    <td>${tempCarac.definition}</td>
                    <td>
                        <a href="${updateLink}">Modifier</a>
                        |
                    </td>
                    <td>
                        <a href="${deleteLink}">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>

</body>
</html>
