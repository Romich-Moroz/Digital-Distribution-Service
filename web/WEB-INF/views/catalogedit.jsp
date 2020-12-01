
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit catalog</title>
</head>
<body>
    <!-- header & navigation -->
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <c:if test="${param.message == 'delsuccess'}">
        <h2>Removed game from database</h2>
    </c:if>
    <c:if test="${param.message == 'delpartsuccess'}">
        <h2>Removed game from catalog, ownerships are not revoked</h2>
    </c:if>
    <c:if test="${param.message == 'delexception'}">
        <h2>Failed to delete game</h2>
    </c:if>
    <c:if test="${param.message == 'addexception'}">
        <h2>Failed to add game</h2>
    </c:if>
    <c:if test="${param.message == 'addsuccess'}">
        <h2>Added game to database</h2>
    </c:if>
    <c:if test="${param.message == 'editexception'}">
        <h2>Failed to edit game</h2>
    </c:if>
    <c:if test="${param.message == 'editsuccess'}">
        <h2>Edited a game successfully</h2>
    </c:if>
    <c:if test="${param.message == 'addkeysexception'}">
        <h2>Failed to add keys</h2>
    </c:if>
    <c:if test="${param.message == 'addkeyssuccess'}">
        <h2>Added keys successfully</h2>
    </c:if>

    <div>
        <form method="post">
            <label>
                Select game to edit/delete:&nbsp;
                <select name="games">
                    <c:forEach items="${gameslist}" var="game">
                        <option value="${game.id}">${game.name}</option>
                    </c:forEach>
                </select>
            </label>
            <button type="submit" formaction="controller?command=deletegame">Delete</button>
            <br/>
            <br/>
            Create new/modify selected game:
            <br/>
            <label>
                Developer:&nbsp;
                <select name="developers">
                    <c:forEach items="${developerslist}" var="developer">
                        <option value="${developer.id}" ${game.developer.id== developer.id ?
                        'selected' : ''}>${developer.developer}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                Genre:&nbsp;
                <select name="genres">
                    <c:forEach items="${genreslist}" var="genre">
                        <option value="${genre.id}" ${game.genre.id== genre.id ?
                        'selected' : ''}>${genre.genre}</option>
                    </c:forEach>
                </select>
            </label>
            <br/>
            <label>
                Name:&nbsp;
                <input type="text" name="gameName"/>
            </label>
            <br/>
            <label>
                Description:&nbsp;
                <input type="text" name="gameDesc"/>
            </label>
            <br/>
            <label>
                Price:&nbsp;
                <input type="text" name="gamePrice"/>
            </label>
            <br/>

            <br/>
            <button type="submit" formaction="controller?command=addgame">Add</button>
            <button type="submit" formaction="controller?command=editgame">Edit</button>
            <br/><br/>
            Add keys to selected game:
            <label>
                <textarea rows="10" cols="30" name="gameKeys" placeholder="Separate keys by newline"></textarea>&nbsp;
            </label>
            <button type="submit" formaction="controller?command=addKeys">Add keys</button>
        </form>

    </div>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
