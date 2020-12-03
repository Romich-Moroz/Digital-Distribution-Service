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

    <fmt:message bundle="${loc}" key="locale.blacklist.title" var="title" />
    <fmt:message bundle="${loc}" key="locale.blacklist.delsuc" var="delsuc" />
    <fmt:message bundle="${loc}" key="locale.blacklist.delexc" var="delexc" />
    <fmt:message bundle="${loc}" key="locale.blacklist.addexc" var="addexc" />
    <fmt:message bundle="${loc}" key="locale.blacklist.addsuc" var="addsuc" />
    <fmt:message bundle="${loc}" key="locale.blacklist.login" var="login" />
    <fmt:message bundle="${loc}" key="locale.blacklist.reason" var="reason" />
    <fmt:message bundle="${loc}" key="locale.blacklist.add" var="add" />
    <fmt:message bundle="${loc}" key="locale.blacklist.remove" var="remove" />
    <fmt:message bundle="${loc}" key="locale.blacklist.logerr" var="error" />
    <title>${title}</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />

    <h2 class="w3-text-white w3-center">
        <cstm:cm expected="delsuccess" actual="${param.message}" message="${delsuc}"/>
        <cstm:cm expected="delexception" actual="${param.message}" message="${delexc}"/>
        <cstm:cm expected="addexception" actual="${param.message}" message="${addexc}"/>
        <cstm:cm expected="addsuccess" actual="${param.message}" message="${addsuc}"/>
        <cstm:cm expected="error" actual="${param.message}" message="${error}"/>
    </h2>

    <div class="w3-display-middle w3-padding w3-large w3-border w3-border-white  w3-round-xxlarge" style="width:30%">
        <div class="w3-center w3-text-white">
            <h2>${title}</h2>
        </div>
        <form method="post">
            <label class="w3-text-white">${login}</label><br/>
            <input class="w3-input w3-border w3-round-large" type="text" name="login" style="width: 62%; display: inline-block" required/>
            <button class="w3-btn w3-text-white w3-border w3-round-xlarge" type="submit" formaction="controller?command=removefromblacklist">${remove}</button><br/><br/>
            <label class="w3-text-white">${reason}</label><br/>
            <textarea class="w3-input w3-border w3-round-large" rows="3" cols="30" name="reason" style="width: 100%"></textarea><br/>
            <button class="w3-btn w3-text-white w3-border w3-round-xlarge" style="width: 100%" type="submit" formaction="controller?command=addtoblacklist">${add}</button>
        </form>
    </div>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
