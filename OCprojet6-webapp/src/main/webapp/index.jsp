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
    <title>Accueil</title>
</head>
<body>
<div id="container" class="col-md-10 col-offset-2">
<h2>Les amis de l'escalade!</h2>
<hr>
<br>
<a href="${pageContext.request.contextPath}/caracteristique/liste">test affichage database</a>
<br><br>
<a href="${pageContext.request.contextPath}/user/connection">test connection utilisateur</a>
</div>
</body>
</html>
