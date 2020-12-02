<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Store</title>
</head>
<body>
    <!-- header & navigation -->
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    <div>
        <c:if test="${param.message == 'addtocartexception'}">
            <h2>Failed to add game to cart</h2>
        </c:if>
        <c:if test="${param.message == 'addtocartsuccess'}">
            <h2>Added game to cart</h2>
        </c:if>
        <form method="post">
            <input type="text" name="gameName" placeholder="Enter game name..." value="${searchRequest}"/>
            <button type="submit" formaction="controller?command=search">Search</button>
        </form>
        <c:forEach items="${catalog}" var="game">
            <div>
                <c:out value = "${game.name} by ${game.developer.developer} only for ${game.price}$"/>
                <c:choose>
                    <c:when test="${user == null}">
                        <button onclick="location.href='controller?command=authredirect'" name="addtocart">Add to cart</button><br/>
                    </c:when>
                    <c:otherwise>
                        <button onclick="location.href='controller?command=addtocart&idGame=${game.id}'" name="addtocart">Add to cart</button><br/>
                    </c:otherwise>
                </c:choose>
            </div>
        </c:forEach>
    </div>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
