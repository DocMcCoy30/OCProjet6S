<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page session="true"%>
<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <title>LogIn</title>
</head>

<body onload='document.loginForm.username.focus();'>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}"><h2>Les amis de l'escalade</h2></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/accueil">Accueil<span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/sites">Sites</a>
        </div>
    </div>
    <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/login">Se connecter</a>
</nav>

<div class="container" id="loginbox">
        <div class="card col-md-4 mx-auto" style="margin-top: 100px;">
            <div class="card-header bg-primary text-white">
                <div class="card-title">Se connecter</div>
            </div>
            <div style="padding-top: 30px" class="card-body">
                <form name="loginForm" action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />"
                      method="POST" class="form-horizontal">
                    <div class="form-group">
                            <c:if test="${ !empty message}">
                                <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                    <c:out value="${message}"/>
                                </div>
                            </c:if>
                        <c:if test="${ !empty error}">
                            <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                <c:out value="${error}"/>
                            </div>
                        </c:if>
                        <c:if test="${ !empty msg}">
                            <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                <c:out value="${msg}"/>
                            </div>
                        </c:if>
                    </div>
                    <!-- Username -->
<%--                    <c:if test="${!empty userRecall}">--%>
<%--                        <c:set var="username" value="${userRecall.username}"></c:set>--%>
<%--                        <c:set var="password" value="${userRecall.password}"></c:set>--%>
<%--                    </c:if>--%>
                    <div style="margin-bottom: 25px" class="input-group">
                        <input type="text" name="username" placeholder="identifiant" class="form-control">
                    </div>
                    <!-- Password -->
                    <div style="margin-bottom: 25px" class="input-group">
                        <input type="password" name="password" placeholder="mot de passe" class="form-control required">
                    </div>

                    <!-- Login/Submit Button -->
                    <div style="margin-top: 10px" class="form-group">
                        <div class="col-sm-8 controls">
                            <button type="submit" class="btn btn-primary">Se connecter</button>
                        </div>
                        <br>
                        <div class="col-sm-12">
                            <a href="${pageContext.request.contextPath}/signin">Vous n'avez pas de compte</a>
                        </div>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}" />

                </form>
            </div>
        </div>
</div>


</body>
</html>