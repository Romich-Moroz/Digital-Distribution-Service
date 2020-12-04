<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/conditionalMessage.tld" prefix="cstm" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style><%@include file="/WEB-INF/css/w3.css"%></style>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />

    <fmt:message bundle="${loc}" key="locale.games.title" var="title" />
    <fmt:message bundle="${loc}" key="locale.games.date" var="date" />
    <fmt:message bundle="${loc}" key="locale.games.developer" var="developer" />
    <fmt:message bundle="${loc}" key="locale.games.game" var="game" />
    <fmt:message bundle="${loc}" key="locale.games.gamesempty" var="gamesempty" />
    <fmt:message bundle="${loc}" key="locale.games.key" var="key" />
    <fmt:message bundle="${loc}" key="locale.games.purexc" var="purexc" />
    <fmt:message bundle="${loc}" key="locale.games.pursuc" var="pursuc" />
    <title>${title}</title>
</head>
<body>
    <header>
        <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    </header>
    <h2 class="w3-text-white w3-center">
        <cstm:cm condition="${param.message == 'purexception'}" message="${purexc}"/>
        <cstm:cm condition="${param.message == 'pursuccess'}" message="${pursuc}"/>
        <cstm:cm condition="${ownedgames.size()==0}" message="${gamesempty}"/>
    </h2>
    <div class="w3-center content" style="width: 100%">
        <c:if test="${ownedgames.size()!=0}">
            <table class="w3-table w3-large w3-border w3-border-white w3-bordered" style="width: 60%; display: inline-block">
                <colgroup>
                    <col style="width:23%">
                    <col style="width:23%">
                    <col style="width:34%">
                    <col style="width:20%">
                </colgroup>
                <tr>
                    <th class="w3-text-white">${game}</th>
                    <th class="w3-text-white">${developer}</th>
                    <th class="w3-text-white">${key}</th>
                    <th class="w3-text-white">${date}</th>
                </tr>
                <c:forEach items="${ownedgames}" var="ownedgame">
                    <tr>
                        <td class="w3-text-white">${ownedgame.name}</td>
                        <td class="w3-text-white">${ownedgame.developer}</td>
                        <td class="w3-text-white">${ownedgame.key}</td>
                        <td class="w3-text-white">${ownedgame.date}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
    <footer>
        <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
    </footer>
</body>
</html>
