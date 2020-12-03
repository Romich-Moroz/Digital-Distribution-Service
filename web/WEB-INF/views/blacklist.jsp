<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="/WEB-INF/tld/conditionalMessage.tld" prefix="cstm" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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

    <cstm:cm expected="delsuccess" actual="${param.message}" message="${delsuc}"/>
    <cstm:cm expected="delexception" actual="${param.message}" message="${delexc}"/>
    <cstm:cm expected="addexception" actual="${param.message}" message="${addexc}"/>
    <cstm:cm expected="addsuccess" actual="${param.message}" message="${addsuc}"/>
    <cstm:cm expected="error" actual="${param.message}" message="${error}"/>

    <div>
        <form method="post">
            <label>
                ${login}<br/>
                <input type="text" name="login" required/>
            </label>
            <button type="submit" formaction="controller?command=removefromblacklist">${remove}</button><br/>
            <label>
                ${reason}<br/>
                <textarea rows="3" cols="30" name="reason"></textarea>&nbsp;
            </label><br/>
            <button type="submit" formaction="controller?command=addtoblacklist">${add}</button>

        </form>

    </div>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
