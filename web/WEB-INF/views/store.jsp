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
    <header>
        <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    </header>

    <h2 class="w3-text-white w3-center">
        <cstm:cm condition="${param.message == 'addtocartexception'}" message="${addcartexc}"/>
        <cstm:cm condition="${param.message == 'addtocartsuccess'}" message="${addcartsuc}"/>
    </h2>

    <div class="content w3-center" style="width: 100%">
        <div class="w3-padding w3-large " style="width:50%; display: inline-block">
            <form method="post">
                <input class="w3-input w3-border w3-round-large" style="display: inline-block; width: 88%" type="text" name="gameName" placeholder="${searchplc}" value="${searchRequest}"/>
                <button class="w3-btn w3-text-white w3-border w3-round-xlarge" type="submit" formaction="controller?command=search">${searchbtn}</button>
            </form>
            <c:forEach items="${catalog}" var="game">
                <div class="w3-padding w3-border-bottom w3-border-white" style="width: 100%; display: inline-block">
                    <div style="width: 40%; display: inline-block" class="w3-left">
                        <table class="w3-table w3-large w3-bordered w3-border-white w3-text-white">
                            <tr>
                                <th>${gamename}</th>
                                <td>${game.name}</td>
                            </tr>
                            <tr>
                                <th>${developer}</th>
                                <td>${game.developer.developer}</td>
                            </tr>
                            <tr>
                                <th>${genre}</th>
                                <td>${game.genre.genre}</td>
                            </tr>
                            <tr>
                                <th>${price}</th>
                                <td>${game.price}$</td>
                            </tr>
                        </table>
                    </div>
                    <div style="width: 60%; display: inline-block" class="w3-center">
                        <div style="height: 80%">
                            <label class="w3-text-white">${desc}</label>
                            <p class="w3-text-white">${game.description}</p>
                        </div>
                        <div style="height: 20%">
                            <c:choose>
                                <c:when test="${user == null}">
                                    <button class="w3-btn w3-text-white w3-border w3-round-xlarge" onclick="location.href='controller?command=authredirect'" name="addtocart">${addcartbtn}</button><br/>
                                </c:when>
                                <c:otherwise>
                                    <button class="w3-btn w3-text-white w3-border w3-round-xlarge" onclick="location.href='controller?command=addtocart&idGame=${game.id}'" name="addtocart">${addcartbtn}</button><br/>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
                <br/><br/>
            </c:forEach>
        </div>
    </div>

    <footer>
        <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
    </footer>
</body>
</html>
