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

    <title>Page de connexion</title>
</head>

<body>
<div class="container">
    <c:url value="/logout" var="logoutUrl"/>
    <header id="header">
        <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
            <a class="navbar-brand" href="${pageContext.request.contextPath}"><h1>Les amis de l'escalade</h1></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/accueil">Home<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/showSearchSitePage">Recherche</a>
                    </li>
                </ul>
            </div>
            <div class="clearfix">
                <form action="searchAll" method="post" class="form-inline mt-2 mt-md-0 mr-2 float-right"
                      id="inputSearchForm">
                    <div class="ui-widget">
                        <input class="form-control mr-sm-2" type="text" id="searchInput" name="motCle">
                    </div>
                    <button class="btn btn-outline-success my-2 mr-5" type="submit">Rechercher</button>
                </form>
            </div>
            <div class="clearfix">
                <c:if test="${pageContext.request.userPrincipal.name == null}">
            <span class="float-right">
            <a class="btn btn-outline-warning" href="${pageContext.request.contextPath}/signin">Creer un compte</a>
            &nbsp
            <a class="btn btn-outline-warning" href="${pageContext.request.contextPath}/login">Se connecter</a>
        </span>
                </c:if>
            </div>
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <div>Bonjour ${pageContext.request.userPrincipal.name}</div>
                &emsp;
                <form action="${logoutUrl}" method="post" id="logoutForm">
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                    <a class="btn btn-outline-warning" href="javascript:lougOutFormSubmit()">Se déconnecter</a>
                </form>
            </c:if>
        </nav>
    </header>

    <div id="body">
        <div class="container" id="loginbox">
            <div class="card mx-auto" style="margin-top: 10em; width: 25em">
                <div class="card-header" id="userCard">
                    <div class="card-title"><h4>Se connecter</h4></div>
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
                            <input type="password" name="password" placeholder="mot de passe"
                                   class="form-control required">
                        </div>

                        <!-- Login/Submit Button -->
                        <div style="margin-top: 10px" class="form-group">
                            <div class="col-sm-8 controls">
                                <button type="submit" class="btn btn-outline-warning">Se connecter</button>
                            </div>
                            <br>
                            <div class="col-sm-12">
                                <a href="${pageContext.request.contextPath}/signin">Vous n'avez pas de compte</a>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>

                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- FOOTER -->
    <footer id="footer" class="page-footer">
        <p class="float-right"><a href="#">Back to top</a></p>
        <p>&copy; 2020 - Les amis de l'escalade &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a>
        </p>
    </footer>
</div>
</body>


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