<%--suppress ELValidationInJSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<div>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />

    <fmt:message bundle="${loc}" key="locale.header.home" var="home" />
    <fmt:message bundle="${loc}" key="locale.header.store" var="store" />
    <fmt:message bundle="${loc}" key="locale.header.games" var="games" />
    <fmt:message bundle="${loc}" key="locale.header.cart" var="cart" />
    <fmt:message bundle="${loc}" key="locale.header.editcatalog" var="editcatalog" />
    <fmt:message bundle="${loc}" key="locale.header.blacklist" var="blacklist" />
    <fmt:message bundle="${loc}" key="locale.header.login" var="login" />
    <fmt:message bundle="${loc}" key="locale.header.logout" var="logout" />
    <fmt:message bundle="${loc}" key="locale.header.welcome" var="welcome" />

    <button onclick="location.href='controller?command=mainredirect'">${home}</button>
    <button onclick="location.href='controller?command=storeredirect'">${store}</button>

    <c:choose>
        <c:when test="${user != null}">
            <button onclick="location.href='controller?command=gamesredirect'">${games}</button>
            <button onclick="location.href='controller?command=cartredirect'">${cart}</button>
            <c:if test="${user.access.type == 'admin'}">
                <button onclick="location.href='controller?command=cateditredirect'">${editcatalog}</button>
                <button onclick="location.href='controller?command=blacklistredirect'">${blacklist}</button>
            </c:if>
            ${welcome},  <c:out value = "${user.login}"/>
            <button onclick="location.href='controller?command=logout'">${logout}</button>
        </c:when>
        <c:otherwise>
            <button onclick="location.href='controller?command=authredirect'">${login}</button>
        </c:otherwise>
    </c:choose>
    <button onclick="location.href='controller?command=changelocale&locale=en'">Eng</button>
    <button onclick="location.href='controller?command=changelocale&locale=ru'">Рус</button>

</div>
