<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit catalog</title>
</head>
<body>
    <!-- header & navigation -->
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <!-- subcategory -->
    <div>
        <form method="post">
            Select a game:&nbsp;
            <select name="games">
                <c:forEach items="${gameslist}" var="game">
                    <option value="${game.id}">${game.name}</option>
                </c:forEach>
            </select>
            <br/><br/>
            <button type="submit" formaction="controller?command=addgame">add</button>
            <button type="submit" formaction="controller?command=editgame">edit</button>
            <button type="submit" formaction="controller?command=deletegame">delete</button>
        </form>

    </div>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
