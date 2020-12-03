<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/conditionalMessage.tld" prefix="cstm" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style><%@include file="/WEB-INF/css/w3.css"%></style>
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
    <h2 class="w3-text-white w3-center">
        <cstm:cm expected="regexception" actual="${param.message}" message="${regexc}"/>
        <cstm:cm expected="regexists" actual="${param.message}" message="${regexi}"/>
    </h2>


    <br/>
    <div class="w3-display-middle w3-padding w3-large w3-border w3-border-white  w3-round-xxlarge" style="width:30%">
        <div class="w3-center w3-text-white">
            <h2>${title}</h2>
        </div>
        <form method="post" action="controller?command=register">
            <label class="w3-text-white">${login}</label>
            <input class="w3-input w3-border w3-round-large" type="text" name="login" required>
            <br/>
            <label class="w3-text-white">${email}</label>
            <input class="w3-input w3-border w3-round-large" type="text" name="email" required>
            <br/>
            <label class="w3-text-white">${pass}</label>
            <input class="w3-input w3-border w3-round-large" type="password" name="pass" required>
            <br/>
            <button class="w3-btn w3-text-white w3-border w3-round-xlarge" style="width: 100%" type="submit">${btn}</button>
        </form>
    </div>
    <br/>


    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
