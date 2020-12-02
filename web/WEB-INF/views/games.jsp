<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Owned games</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <div>
        <c:forEach items="${ownedgames}" var="ownedgame">
            <c:out value = "${ownedgame.name} by ${ownedgame.developer} key ${ownedgame.key} bought ${ownedgame.date}"/><br/>
        </c:forEach>
    </div>


    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
