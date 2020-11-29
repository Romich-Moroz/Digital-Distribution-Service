<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <c:if test="${param.message == 'logexception'}">
        <h2>Internal error occurred: try again later</h2>
    </c:if>
    <c:if test="${param.message == 'logerror'}">
        <h2>Invalid login data</h2>
    </c:if>
    <form method="post" action="controller?command=authorize">
        <label>Login:
            <input type="text" name="login" required><br/>
        </label>

        <label>Password:
            <input type="password" name="pass" required><br />
        </label>
        <button type="submit">Submit</button>
    </form>
    <button onclick="location.href='controller?command=regredirect'">Register</button>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
