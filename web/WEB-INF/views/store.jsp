<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/conditionalMessage.tld" prefix="cstm" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style><%@include file="/WEB-INF/css/w3.css"%></style>
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
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <h2 class="w3-text-white w3-center">
        <cstm:cm expected="addtocartexception" actual="${param.message}" message="${addcartexc}"/>
        <cstm:cm expected="addtocartsuccess" actual="${param.message}" message="${addcartsuc}"/>
    </h2>


    <div>
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
