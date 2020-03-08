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

    <title>Modele</title>
</head>

<%@include file="header.jsp" %>

<div id="body">
    <div class="container">
        <div id="commentaire-panel">
            <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                <h2>Listes des commentaires à valider :</h2>
                <ul class="list-unstyled">
                    <c:if test="${empty commentaires}">
                        <h5 style="color: red">Il n'y a aucun commentaire à valider.</h5>
                    </c:if>
                    <c:if test="${! empty commentaires}">
                        <c:forEach var="commentaire" items="${commentaires}">
                            <li class="media">
                                <div class="media-body" id="commentaire-div">
                                    <div class="row">
                                        <div class="col" style="color: yellow; font-size: larger">
                                            Posté par ${commentaire.users.username} le ${commentaire.date}
                                        </div>
                                        <div class="col-auto pull-right">
                                            <input type="checkbox" id="validation" name="commentaireId"
                                                   value="${commentaire.id}">
                                        </div>
                                    </div>
                                    <div style="color: #F2E8C9">${commentaire.commentaire}</div>
                                </div>
                            </li>
                        </c:forEach>
                    </c:if>
                </ul>
                <div class="text-center">
                    <a href="${pageContext.request.contextPath}/showPagePerso" type="button"
                       class="btn btn-warning" id="btnRefresh">Rafraichir</a>
                </div>
            </c:if>
        </div>
        <div id="user-panel">
            <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                <h2>Listes des utilisateurs :</h2>
                <table class="table table-dark" id="userTable">
                    <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Email</th>
                        <th>Utilisateur</th>
                        <th>Administrateur</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:if test="${empty users}">
                        <h5 style="color: red">Il n'y a aucun utilisateur.</h5>
                    </c:if>
                    <c:if test="${! empty users}">
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.username}</td>
                                <td>${user.email}</td>
                                <c:if test="${user.userRole =='ROLE_USER'}">
                                    <td>
                                        <div class="col-auto pull-right">
                                            <input type="checkbox" id="utilisateur" name="username"
                                                   value="${user.username}" checked="checked">
                                        </div>
                                    </td>
                                    <td>
                                        <div class="col-auto pull-right">
                                            <input type="checkbox" id="administrateur" name="administrateur"
                                                   value="${user.username}">
                                        </div>
                                    </td>
                                </c:if>
                                <c:if test="${user.userRole == 'ROLE_ADMIN'}">
                                    <td>
                                        <div class="col-auto pull-right">
                                            <input type="checkbox" id="utilisateur" name="username"
                                                   value="${user.username}">
                                        </div>
                                    </td>
                                    <td>
                                        <div class="col-auto pull-right">
                                            <input type="checkbox" id="administrateur" name="administrateur"
                                                   value="${user.username}" checked="checked">
                                        </div>
                                    </td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </c:if>
                    </tbody>
                </table>
                <%--                <ul class="list-unstyled">--%>
                <%--                    <c:if test="${empty users}">--%>
                <%--                        <h5 style="color: red">Il n'y a aucun utilisateur.</h5>--%>
                <%--                    </c:if>--%>
                <%--                    <c:if test="${! empty users}">--%>
                <%--                        <c:forEach var="user" items="${users}">--%>
                <%--                            <li class="media">--%>
                <%--                                <div class="media-body" id="user-div">--%>
                <%--                                    <div class="row">--%>
                <%--                                        <div class="col">--%>
                <%--                                            Nom : ${user.username} - Email :${user.email}--%>
                <%--                                        </div>--%>
                <%--                                        <div class="col-auto pull-right">--%>
                <%--                                            <input type="checkbox" id="utilisateur" name="username"--%>
                <%--                                                   value="${user.username}">--%>
                <%--                                        </div>--%>
                <%--                                        <div class="col-auto pull-right">--%>
                <%--                                            <input type="checkbox" id="administrateur" name="administrateur"--%>
                <%--                                                   value="${user.username}">--%>
                <%--                                        </div>--%>
                <%--                                    </div>--%>
                <%--                                </div>--%>
                <%--                            </li>--%>
                <%--                        </c:forEach>--%>
                <%--                    </c:if>--%>
                <%--                </ul>--%>
                <%--                <div class="text-center">--%>
                <%--                    <a href="${pageContext.request.contextPath}/showPagePerso" type="button"--%>
                <%--                       class="btn btn-warning" id="btnRefresh">Rafraichir</a>--%>
                <%--                </div>--%>
                <%--            </c:if>--%>
            </c:if>
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
