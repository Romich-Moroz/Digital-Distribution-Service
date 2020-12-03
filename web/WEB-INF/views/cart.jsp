<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/conditionalMessage.tld" prefix="cstm" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />

    <fmt:message bundle="${loc}" key="locale.cart.title" var="title" />
    <fmt:message bundle="${loc}" key="locale.cart.delsuc" var="delsuc" />
    <fmt:message bundle="${loc}" key="locale.cart.delexc" var="delexc" />
    <fmt:message bundle="${loc}" key="locale.cart.game" var="game" />
    <fmt:message bundle="${loc}" key="locale.cart.price" var="price" />
    <fmt:message bundle="${loc}" key="locale.cart.remove" var="remove" />
    <fmt:message bundle="${loc}" key="locale.cart.sum" var="sum" />
    <fmt:message bundle="${loc}" key="locale.cart.empty" var="cartempty" />
    <fmt:message bundle="${loc}" key="locale.cart.cardnumb" var="card" />
    <fmt:message bundle="${loc}" key="locale.cart.holder" var="holder" />
    <fmt:message bundle="${loc}" key="locale.cart.secnumb" var="CVV" />
    <fmt:message bundle="${loc}" key="locale.cart.expdate" var="expdate"/>
    <fmt:message bundle="${loc}" key="locale.cart.purchase" var="purchase"/>
    <title>${title}</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    <div>
        <cstm:cm expected="delfromcartexception" actual="${param.message}" message="${delexc}"/>
        <cstm:cm expected="delfromcartsuccess" actual="${param.message}" message="${delsuc}"/>

        <c:choose>
            <c:when test="${cart != null}">
                <c:set var="total" value="${0}"/>
                <table>
                    <tr>
                        <th>${game}</th>
                        <th>${price}</th>
                    </tr>
                    <c:forEach items="${cart}" var="game">
                        <tr>
                            <td>${game.name}</td>
                            <td>${game.price}$</td>
                            <td><button onclick="location.href='controller?command=delfromcart&idGame=${game.id}'">${remove}</button></td>
                            <c:set var="total" value="${total + game.price}" />
                        </tr>
                    </c:forEach>
                </table>
                <fmt:formatNumber var="formattedTotal" type="number" minFractionDigits="2" maxFractionDigits="2" value="${total}" />
                <c:out value="${sum}: ${formattedTotal}$"/>
            </c:when>
            <c:otherwise>
                <c:out value="${cartempty}"/>
            </c:otherwise>
        </c:choose>

        <br/><br/>

        <form method="post">
            <label>
                ${card}:&nbsp;
                <input type="text" name="cardNumb" required/>
            </label>
            <br/>
            <label>
                ${holder}:&nbsp;
                <input type="text" name="name" required/>
            </label>
            <br/>
            <label>
                ${expdate}:&nbsp;
                <input type="text" name="date" required/>
            </label>
            <br/>
            <label>
                ${CVV}:&nbsp;
                <input type="text" name="security" required/>
            </label>
            <br/>
            <button type="submit" formaction="controller?command=purchase">${purchase}</button>
        </form>

    </div>
    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
