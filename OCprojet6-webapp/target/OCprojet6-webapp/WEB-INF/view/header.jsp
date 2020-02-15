    <c:url value="/logout" var="logoutUrl"/>
    <header id="header">
        <nav class="navbar navbar-expand-lg navbar-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}"><h1>Les amis de l'escalade</h1></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="${pageContext.request.contextPath}/accueil">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/showSearchSitePage">Recherche</a>
                    </li>
                </ul>
            </div>
            <div class="clearfix">
                <form action="searchAll" method="post" class="form-inline mt-2 mt-lg-0 mr-2 float-right"
                      id="inputSearchForm">
                    <div class="ui-widget">
                        <input class="form-control mr-sm-2" type="text" id="searchInput" name="motCle">
                    </div>
                    <button class="btn btn-outline-success my-2 mr-5" type="submit">Rechercher</button>
                </form>
            </div>
            <div class="clearfix">
                <c:if test="${pageContext.request.userPrincipal.name == null}">
            <span class="float-right form-inline">
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

