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

    <title>Page de création de compte</title>
</head>

<%@include file="header.jsp" %>

    <div id="body">
        <div class="container" id="signinbox">
            <div class="card mx-auto" style="margin-top: 10em; width: 25em">
                <div class="card-header" id="userCard">
                    <div class="card-title"><h4>Créer un compte</h4></div>
                </div>
                <div class="card-body" style="padding-top: 30px">

                    <form action="signup" modelAttribute="users"
                          method="POST" class="form-horizontal">
                        <div class="form-group">
                            <div class="col-xs-15">
                                <div>
                                    <c:if test="${ !empty error}">
                                        <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                            <c:out value="${error}"/>
                                        </div>
                                    </c:if>
                                </div>
                                <div>
                                    <c:if test="${ !empty message}">
                                        <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                            <c:out value="${message}"/>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">
                            <input type="text" name="username" placeholder="identifiant" class="form-control" required>
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">
                            <input type="email" name="email" placeholder="email" class="form-control">
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">
                            <input type="password" name="password" placeholder="mot de passe" class="form-control"
                                   required>
                        </div>
                        <!-- Login/Submit Button -->
                        <div style="margin-top: 10px" class="form-group">
                            <div class="col-sm-8 controls">
                                <button type="submit" class="btn btn-outline-warning">Creer un compte</button>
                            </div>
                            <br>
                            <div class="col-sm-12">
                                <a href="${pageContext.request.contextPath}/login">Vous avez déjà un compte</a>
                            </div>
                        </div>
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