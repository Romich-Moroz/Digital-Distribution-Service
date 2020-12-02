<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />

    <fmt:message bundle="${loc}" key="locale.games.title" var="title" />
    <fmt:message bundle="${loc}" key="locale.games.date" var="date" />
    <fmt:message bundle="${loc}" key="locale.games.developer" var="developer" />
    <fmt:message bundle="${loc}" key="locale.games.game" var="game" />
    <fmt:message bundle="${loc}" key="locale.games.gamesempty" var="gamesempty" />
    <fmt:message bundle="${loc}" key="locale.games.key" var="key" />
    <title>${title}</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <div>
        <c:choose>
            <c:when test="${ownedgames.size()!=0}">
                <table>
                    <tr>
                        <th>${game}</th>
                        <th>${developer}</th>
                        <th>${key}</th>
                        <th>${date}</th>
                    </tr>
                    <c:forEach items="${ownedgames}" var="ownedgame">
                        <tr>
                            <td>${ownedgame.name}</td>
                            <td>${ownedgame.developer}</td>
                            <td>${ownedgame.key}</td>
                            <td>${ownedgame.date}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <c:out value="${gamesempty}"/>
            </c:otherwise>
        </c:choose>


    </div>
    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
