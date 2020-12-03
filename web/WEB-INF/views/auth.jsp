<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/conditionalMessage.tld" prefix="cstm" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style><%@include file="/WEB-INF/css/w3.css"%></style>
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

    <h2 class="w3-text-white w3-center">
        <cstm:cm expected="logexception" actual="${param.message}" message="${logexc}"/>
        <cstm:cm expected="logerror" actual="${param.message}" message="${logerr}"/>
        <cstm:cm expected="logbanned" actual="${param.message}" message="${logban}"/>
    </h2>


    <br/>
    <div class="w3-display-middle w3-padding w3-large w3-border w3-border-white  w3-round-xxlarge" style="width:30%">
        <div class="w3-center w3-text-white">
            <h2>${title}</h2>
        </div>
        <form method="post" action="controller?command=authorize">
            <label class="w3-text-white">${login}</label>
            <input class="w3-input w3-border w3-round-large" type="text" name="login" required/>
            <br/>
            <label class="w3-text-white">${pass}</label>
            <input class="w3-input w3-border w3-round-large" type="password" name="pass" required/>
            <br/>
            <button class="w3-btn w3-text-white w3-border w3-round-xlarge" type="button" onclick="location.href='controller?command=regredirect'">${regbtn}</button>
            <button class="w3-btn w3-text-white w3-border w3-round-xlarge w3-right" style="width: 65%">${logbtn}</button>
        </form>
    </div>
    <br/>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
