<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Customers</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Test Caracteristique</h2>
    </div>
</div>
<div id="container">
    <div id="content">
        <input type="button" value="Ajout Caracteristique"
        onclick="window.location.href='formulaireAjout' ; return false;"
        class="add-button"
        />
        <table>
            <tr>
                <th>Nom</th>
                <th>Definition</th>
            </tr>
            <c:forEach var="tempCarac" items="${caracteristiques}">
                <tr>
                    <td>${tempCarac.nom}</td>
                    <td>${tempCarac.definition}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
</div>

</body>
</html>
