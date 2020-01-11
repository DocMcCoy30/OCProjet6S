<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save Customer</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>

<div id="wrapper">
    <div id="header">
        <h2>Ajout Caracteristique</h2>
    </div>
</div>
<div id="container">

    <form:form action="updateCaracteristique" modelAttribute="caracteristique" method="POST">
        <form:hidden path="id" />
        <table>
            <tbody>
            <tr>
                <td><label>Nom :</label></td>
                <td><form:input path="nom"/></td>
            </tr>
            <tr>
                <td><label>Definition:</label></td>
                <td><form:input path="definition"/></td>
            </tr>
            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Update"/></td>
            </tr>
            </tbody>
        </table>
    </form:form>
    <div style="clear:both"></div>
    <p>
        <a href="${pageContext.request.contextPath}/caracteristique/liste">Back to list</a>
    </p>
</div>
</body>
</html>
