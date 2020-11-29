<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <c:if test="${param.message == 'regexception'}">
        <h2>Internal error occurred: try again later</h2>
    </c:if>
    <c:if test="${param.message == 'regexists'}">
        <h2>Login or email already in use</h2>
    </c:if>
    <form method="post" action="controller?command=register">
        <label>Login:
            <input type="text" name="login" required><br />
        </label>

        <label>Email:
            <input type="text" name="email" required><br />
        </label>
        <label>Password:
            <input type="password" name="pass" required><br />
        </label>
        <button type="submit">Submit</button>
    </form>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
