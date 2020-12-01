<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Manage blacklist</title>
</head>
<body>
    <!-- header & navigation -->
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <c:if test="${param.message == 'delsuccess'}">
        <h2>Removed user from blacklist</h2>
    </c:if>
    <c:if test="${param.message == 'delexception'}">
        <h2>Failed to remove user from blacklist</h2>
    </c:if>
    <c:if test="${param.message == 'addexception'}">
        <h2>Failed to add user to blacklist</h2>
    </c:if>
    <c:if test="${param.message == 'addsuccess'}">
        <h2>Added user to blacklist</h2>
    </c:if>

    <div>
        <form method="post">
            <label>
                User login to ban:&nbsp;
                <input type="text" name="login"/>
            </label>
            Reason for ban:
            <label>
                <textarea rows="3" cols="30" name="reason" placeholder="Type reason here..."></textarea>&nbsp;
            </label>
            <button type="submit" formaction="controller?command=addtoblacklist">Add</button>
            <button type="submit" formaction="controller?command=removefromblacklist">Remove</button>
        </form>

    </div>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
