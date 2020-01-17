<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>Page de connection</title>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">Les amis de l'escalade</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/accueil">Accueil<span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="#">Sites</a>
        </div>
    </div>
    <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/users/connection">Se connecter</a>
</nav>

<div class="container" id="loginbox">
        <div class="card col-md-4 mx-auto" style="margin-top: 100px;">
            <div class="card-header bg-primary text-white">
                <div class="card-title">Se connecter</div>
            </div>
            <div style="padding-top: 30px" class="card-body">
                <form:form action="${pageContext.request.contextPath}/authenticateTheUser"
                      method="POST" class="form-horizontal">
                    <div class="form-group">
                        <div class="col-xs-15">
                            <div>
                                <c:if test="${ !empty error}">
                                    <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                        <c:out value="${error}" />
                                    </div>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <!-- User name -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input type="text" name="identifiant" placeholder="identifiant" class="form-control">
                    </div>
                    <!-- Password -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input type="password" name="password" placeholder="mot de passe" class="form-control required">
                    </div>
                    <!-- Login/Submit Button -->
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-8 controls">
                            <button type="submit" class="btn btn-primary">Se connecter</button>
                        </div>
                        <br>
                        <div class="col-sm-12">
                            <a href="${pageContext.request.contextPath}/users/creation">Vous n'avez pas de compte</a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
</div>


</body>
</html>