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
    <title>Modifier une caracteristique</title>
</head>
<body>

<div id="wrapper"class="col-md-10 col-offset-2">
    <div id="header">
        <h2>Modification d'une Caracteristique</h2>
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
    <p>
        <a href="${pageContext.request.contextPath}/caracteristique/liste">Retour à la liste</a>
    </p>
</div>
</body>
</html>
