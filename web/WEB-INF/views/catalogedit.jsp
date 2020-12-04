<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/conditionalMessage.tld" prefix="cstm" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style><%@include file="/WEB-INF/css/w3.css"%></style>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />

    <fmt:message bundle="${loc}" key="locale.catalog.title" var="title" />
    <fmt:message bundle="${loc}" key="locale.catalog.add" var="add" />
    <fmt:message bundle="${loc}" key="locale.catalog.addexc" var="addexc" />
    <fmt:message bundle="${loc}" key="locale.catalog.addkeysbtn" var="addkeysbtn" />
    <fmt:message bundle="${loc}" key="locale.catalog.addkeysexc" var="addkeysexc" />
    <fmt:message bundle="${loc}" key="locale.catalog.addkeyslbl" var="addkeyslbl" />
    <fmt:message bundle="${loc}" key="locale.catalog.addkeysplc" var="addkeysplc" />
    <fmt:message bundle="${loc}" key="locale.catalog.addkeyssuc" var="addkeyssuc" />
    <fmt:message bundle="${loc}" key="locale.catalog.addsuc" var="addsuc" />
    <fmt:message bundle="${loc}" key="locale.catalog.create" var="create" />
    <fmt:message bundle="${loc}" key="locale.catalog.delete" var="delete" />
    <fmt:message bundle="${loc}" key="locale.catalog.delexc" var="delexc"/>
    <fmt:message bundle="${loc}" key="locale.catalog.delpart" var="delpart"/>
    <fmt:message bundle="${loc}" key="locale.catalog.delsuc" var="delsuc"/>
    <fmt:message bundle="${loc}" key="locale.catalog.desc" var="desc"/>
    <fmt:message bundle="${loc}" key="locale.catalog.editsuc" var="editsuc"/>
    <fmt:message bundle="${loc}" key="locale.catalog.editexc" var="editexc"/>
    <fmt:message bundle="${loc}" key="locale.catalog.select" var="select"/>
    <fmt:message bundle="${loc}" key="locale.catalog.edit" var="edit"/>
    <fmt:message bundle="${loc}" key="locale.catalog.developer" var="developer"/>
    <fmt:message bundle="${loc}" key="locale.catalog.genre" var="genre"/>
    <fmt:message bundle="${loc}" key="locale.catalog.name" var="name"/>
    <fmt:message bundle="${loc}" key="locale.catalog.price" var="price"/>

    <title>${title}</title>
</head>
<body>
    <header>
        <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    </header>

    <h2 class="w3-text-white w3-center">
        <cstm:cm condition="${param.message == 'delsuccess'}" message="${delsuc}"/>
        <cstm:cm condition="${param.message == 'delpartsuccess'}" message="${delpart}"/>
        <cstm:cm condition="${param.message == 'delexception'}" message="${delexc}"/>
        <cstm:cm condition="${param.message == 'addexception'}" message="${addexc}"/>
        <cstm:cm condition="${param.message == 'addsuccess'}" message="${addsuc}"/>
        <cstm:cm condition="${param.message == 'editexception'}" message="${editexc}"/>
        <cstm:cm condition="${param.message == 'editsuccess'}" message="${editsuc}"/>
        <cstm:cm condition="${param.message == 'addkeysexception'}" message="${addkeysexc}"/>
        <cstm:cm condition="${param.message == 'addkeyssuccess'}" message="${addkeyssuc}"/>
    </h2>

    <div class="w3-center content" style="width: 100%">
        <div class="w3-padding w3-large w3-border w3-border-white  w3-round-xxlarge" style="width:30%; display: inline-block">
            <div class="w3-center w3-text-white">
                <h2>${select}</h2>
            </div>
            <form method="post">
                <select class="w3-select" name="games">
                    <c:forEach items="${gameslist}" var="game">
                        <option value="${game.id}">${game.name}</option>
                    </c:forEach>
                </select><br/><br/>
                <button style="width: 100%" class="w3-btn w3-text-white w3-border w3-round-xlarge w3-right" type="submit" formaction="controller?command=deletegame">${delete}</button>
            </form>
        </div>
        <br/><br/>

        <div class="w3-padding w3-large w3-border w3-border-white  w3-round-xxlarge" style="width:30%; display: inline-block">
            <div class="w3-center w3-text-white">
                <h2>${create}</h2>
            </div>
            <form method="post">

                <select class="w3-select" name="games">
                    <c:forEach items="${gameslist}" var="game">
                        <option value="${game.id}">${game.name}</option>
                    </c:forEach>
                </select>

                <label class="w3-text-white">${developer}</label>

                <select class="w3-select" name="developers">
                    <c:forEach items="${developerslist}" var="developer">
                        <option value="${developer.id}">${developer.developer}</option>
                    </c:forEach>
                </select>
                <label class="w3-text-white">${genre}</label>
                <select class="w3-select" name="genres">
                    <c:forEach items="${genreslist}" var="genre">
                        <option value="${genre.id}">${genre.genre}</option>
                    </c:forEach>
                </select>

                <label class="w3-text-white">${name}</label>
                <input class="w3-input w3-border w3-round-large" type="text" name="gameName" required/>
                <label class="w3-text-white">${desc}</label>
                <textarea style="width: 100%" class="w3-text" rows="10" cols="30" name="gameDesc" required></textarea>
                <label class="w3-text-white">${price}</label>
                <input class="w3-input w3-border w3-round-large" type="text" name="gamePrice" required/><br/>
                <button style="width: 45%" class="w3-btn w3-left w3-text-white w3-border w3-round-xlarge" type="submit" formaction="controller?command=addgame">${add}</button>
                <button style="width: 45%" class="w3-btn w3-right w3-text-white w3-border w3-round-xlarge" type="submit" formaction="controller?command=editgame">${edit}</button>
            </form>
        </div>
        <br/><br/>
        <div class="w3-padding w3-large w3-border w3-border-white  w3-round-xxlarge" style="width:30%; display: inline-block">
            <div class="w3-center w3-text-white">
                <h2>${addkeyslbl}</h2>
            </div>
            <form method="post">
                <select class="w3-select" name="games">
                    <c:forEach items="${gameslist}" var="game">
                        <option value="${game.id}">${game.name}</option>
                    </c:forEach>
                </select>
                <br/><br/>
                <textarea style="width: 100%" class="w3-text" rows="10" cols="30" name="gameKeys" placeholder="${addkeysplc}" required></textarea>&nbsp;
                <br/>
                <button style="width: 100%" class="w3-btn w3-text-white w3-border w3-round-xlarge" type="submit" formaction="controller?command=addKeys">${addkeysbtn}</button>
            </form>
        </div>
    </div>

    <footer>
        <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
    </footer>
</body>
</html>
