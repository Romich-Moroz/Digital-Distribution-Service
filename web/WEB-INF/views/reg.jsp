<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />

    <fmt:message bundle="${loc}" key="locale.reg.title" var="title" />
    <fmt:message bundle="${loc}" key="locale.reg.email" var="email" />
    <fmt:message bundle="${loc}" key="locale.reg.btn" var="btn" />
    <fmt:message bundle="${loc}" key="locale.reg.login" var="login" />
    <fmt:message bundle="${loc}" key="locale.reg.pass" var="pass" />
    <fmt:message bundle="${loc}" key="locale.reg.regexc" var="regexc" />
    <fmt:message bundle="${loc}" key="locale.reg.regexi" var="regexi" />
    <title>${title}</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <c:if test="${param.message == 'regexception'}">
        <h2>${regexc}</h2>
    </c:if>
    <c:if test="${param.message == 'regexists'}">
        <h2>${regexi}</h2>
    </c:if>
    <form method="post" action="controller?command=register">
        <label>${login}:
            <input type="text" name="login" required><br />
        </label>

        <label>${email}:
            <input type="text" name="email" required><br />
        </label>
        <label>${pass}:
            <input type="password" name="pass" required><br />
        </label>
        <button type="submit">${btn}</button>
    </form>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
