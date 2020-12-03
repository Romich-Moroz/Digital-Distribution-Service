<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/tld/conditionalMessage.tld" prefix="cstm" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <cstm:cm expected="delsuccess" actual="${param.message}" message="${delsuc}"/>
    <cstm:cm expected="delpartsuccess" actual="${param.message}" message="${delpart}"/>
    <cstm:cm expected="delexception" actual="${param.message}" message="${delexc}"/>
    <cstm:cm expected="addexception" actual="${param.message}" message="${addexc}"/>
    <cstm:cm expected="addsuccess" actual="${param.message}" message="${addsuc}"/>
    <cstm:cm expected="editexception" actual="${param.message}" message="${editexc}"/>
    <cstm:cm expected="editsuccess" actual="${param.message}" message="${editsuc}"/>
    <cstm:cm expected="addkeysexception" actual="${param.message}" message="${addkeysexc}"/>
    <cstm:cm expected="addkeyssuccess" actual="${param.message}" message="${addkeyssuc}"/>

    <div>
        <form method="post">
            <label>
                ${select}:&nbsp;
                <select name="games">
                    <c:forEach items="${gameslist}" var="game">
                        <option value="${game.id}">${game.name}</option>
                    </c:forEach>
                </select>
            </label>
            <button type="submit" formaction="controller?command=deletegame">${delete}</button>
        </form>

        <form method="post">
            <label>
                ${create}
                <select name="games">
                    <c:forEach items="${gameslist}" var="game">
                        <option value="${game.id}">${game.name}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                ${developer}&nbsp;
                <select name="developers">
                    <c:forEach items="${developerslist}" var="developer">
                        <option value="${developer.id}">${developer.developer}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                ${genre}&nbsp;
                <select name="genres">
                    <c:forEach items="${genreslist}" var="genre">
                        <option value="${genre.id}">${genre.genre}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                ${name}&nbsp;
                <input type="text" name="gameName" required/>
            </label>
            <br/>
            <label>
                ${desc}&nbsp;
                <input type="text" name="gameDesc" required/>
            </label>
            <br/>
            <label>
                ${price}&nbsp;
                <input type="text" name="gamePrice" required/>
            </label>
            <br/>
            <button type="submit" formaction="controller?command=addgame">${add}</button>
            <button type="submit" formaction="controller?command=editgame">${edit}</button>
        </form>

        <form method="post">
            <label>
                ${addkeyslbl}
                <select name="games">
                    <c:forEach items="${gameslist}" var="game">
                        <option value="${game.id}">${game.name}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                <textarea rows="10" cols="30" name="gameKeys" placeholder="${addkeysplc}" required></textarea>&nbsp;
            </label><br/>
            <button type="submit" formaction="controller?command=addKeys">${addkeysbtn}</button>
        </form>
    </div>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
