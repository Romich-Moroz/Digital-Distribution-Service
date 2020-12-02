<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />

    <fmt:message bundle="${loc}" key="locale.auth.title" var="title" />
    <fmt:message bundle="${loc}" key="locale.auth.error.logban" var="logban" />
    <fmt:message bundle="${loc}" key="locale.auth.error.logerr" var="logerr" />
    <fmt:message bundle="${loc}" key="locale.auth.error.logexc" var="logexc" />
    <fmt:message bundle="${loc}" key="locale.auth.login" var="login" />
    <fmt:message bundle="${loc}" key="locale.auth.pass" var="pass" />
    <fmt:message bundle="${loc}" key="locale.auth.regbtn" var="regbtn" />
    <fmt:message bundle="${loc}" key="locale.auth.logbtn" var="logbtn" />
    <fmt:message bundle="${loc}" key="locale.auth.login" var="login" />
    <title>${title}</title>
</head>
<body>

    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <c:if test="${param.message == 'logexception'}">
        <h2>${logexc}</h2>
    </c:if>
    <c:if test="${param.message == 'logerror'}">
        <h2>${logerr}</h2>
    </c:if>
    <c:if test="${param.message == 'logbanned'}">
        <h2>${logban}</h2>
    </c:if>
    <form method="post" action="controller?command=authorize">
        <label>${login}:
            <input type="text" name="login" required><br/>
        </label>

        <label>${pass}:
            <input type="password" name="pass" required><br />
        </label>
        <button type="button" onclick="location.href='controller?command=regredirect'">${regbtn}</button>
        <button type="submit">${logbtn}</button>
    </form>



    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
