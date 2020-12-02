<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />

    <fmt:message bundle="${loc}" key="locale.store.title" var="title" />
    <fmt:message bundle="${loc}" key="locale.store.addcartbtn" var="addcartbtn" />
    <fmt:message bundle="${loc}" key="locale.store.addcartexc" var="addcartexc" />
    <fmt:message bundle="${loc}" key="locale.store.addcartsuc" var="addcartsuc" />
    <fmt:message bundle="${loc}" key="locale.store.desc" var="desc" />
    <fmt:message bundle="${loc}" key="locale.store.developer" var="developer" />
    <fmt:message bundle="${loc}" key="locale.store.game" var="gamename" />
    <fmt:message bundle="${loc}" key="locale.store.genre" var="genre" />
    <fmt:message bundle="${loc}" key="locale.store.price" var="price" />
    <fmt:message bundle="${loc}" key="locale.store.searchplc" var="searchplc" />
    <fmt:message bundle="${loc}" key="locale.store.searchbtn" var="searchbtn" />
    <title>${title}</title>
</head>
<body>
    <!-- header & navigation -->
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    <div>
        <c:if test="${param.message == 'addtocartexception'}">
            <h2>${addcartexc}</h2>
        </c:if>
        <c:if test="${param.message == 'addtocartsuccess'}">
            <h2>${addcartsuc}</h2>
        </c:if>
        <form method="post">
            <input type="text" name="gameName" placeholder="${searchplc}" value="${searchRequest}"/>
            <button type="submit" formaction="controller?command=search">${searchbtn}</button>
        </form>
        <c:forEach items="${catalog}" var="game">
            <div>
                <c:out value="${gamename}: ${game.name}"/><br/>
                <c:out value="${developer}: ${game.developer.developer}"/><br/>
                <c:out value="${genre}: ${game.genre.genre}"/><br/>
                <c:out value="${price}: ${game.price}$"/><br/>
                <c:out value="${desc}: ${game.description}"/><br/>
                <c:choose>
                    <c:when test="${user == null}">
                        <button onclick="location.href='controller?command=authredirect'" name="addtocart">${addcartbtn}</button><br/>
                    </c:when>
                    <c:otherwise>
                        <button onclick="location.href='controller?command=addtocart&idGame=${game.id}'" name="addtocart">${addcartbtn}</button><br/>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
    </div>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
