<%--suppress ELValidationInJSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
<fmt:message bundle="${loc}" key="locale.header.language" var="language" />

<div class="w3-bar w3-black w3-large" >
    <a href="controller?command=mainredirect" class="w3-bar-item w3-button">${home}</a>
    <a href="controller?command=storeredirect" class="w3-bar-item w3-button">${store}</a>
    <c:choose>
        <c:when test="${user != null}">
            <a href="controller?command=gamesredirect" class="w3-bar-item w3-button">${games}</a>
            <a href="controller?command=cartredirect" class="w3-bar-item w3-button">${cart}</a>
            <c:if test="${user.access.type == 'admin'}">
                <a href="controller?command=cateditredirect" class="w3-bar-item w3-button">${editcatalog}</a>
                <a href="controller?command=blacklistredirect" class="w3-bar-item w3-button">${blacklist}</a>
            </c:if>
            <a href="controller?command=logout" class="w3-bar-item w3-button w3-right">${logout}</a>
            <span class="w3-bar-item w3-right">${welcome},  <c:out value = "${user.login}"/></span>
            <div class="w3-dropdown-hover w3-mobile w3-right">
                <button class="w3-button">${language} <i class="fa fa-caret-down"></i></button>
                <div class="w3-dropdown-content w3-bar-block w3-black">
                    <a href="controller?command=changelocale&locale=en" class="w3-bar-item w3-button w3-mobile">Eng</a>
                    <a href="controller?command=changelocale&locale=ru" class="w3-bar-item w3-button w3-mobile">Рус</a>
                </div>
            </div>

        </c:when>
        <c:otherwise>
            <a href="controller?command=authredirect" class="w3-bar-item w3-button w3-right">${login}</a>
            <div class="w3-dropdown-hover w3-mobile w3-right">
                <button class="w3-button">${language} <i class="fa fa-caret-down"></i></button>
                <div class="w3-dropdown-content w3-bar-block w3-black">
                    <a href="controller?command=changelocale&locale=en" class="w3-bar-item w3-button w3-mobile">Eng</a>
                    <a href="controller?command=changelocale&locale=ru" class="w3-bar-item w3-button w3-mobile">Рус</a>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>
