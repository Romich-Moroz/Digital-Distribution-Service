<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/tld/conditionalMessage.tld" prefix="cstm" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style><%@include file="/WEB-INF/css/w3.css"%></style>
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
    <header>
        <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    </header>
    <h2 class="w3-text-white w3-center">
        <cstm:cm condition="${param.message == 'delfromcartexception'}" message="${delexc}"/>
        <cstm:cm condition="${param.message == 'delfromcartsuccess'}" message="${delsuc}"/>
        <cstm:cm condition="${cart == null}" message="${cartempty}"/>
    </h2>
    <div class="content w3-center" style="width: 100%">
        <c:if test="${cart != null}">
            <c:set var="total" value="${0}"/>
            <table class="w3-table w3-large w3-border w3-border-white w3-bordered" style="width: 30%; display: inline-block">
                <colgroup>
                    <col style="width:75%">
                    <col style="width:25%">
                </colgroup>
                <tr>
                    <th class="w3-text-white">${game}</th>
                    <th class="w3-text-white">${price}</th>
                </tr>
                <c:forEach items="${cart}" var="game">
                    <tr>
                        <td class="w3-text-white">${game.name}</td>
                        <td class="w3-text-white">${game.price}$ <button class="w3-button w3-circle w3-text-white w3-red w3" onclick="location.href='controller?command=delfromcart&idGame=${game.id}'">&times</button></td>
                        <c:set var="total" value="${total + game.price}" />
                    </tr>
                </c:forEach>
                <fmt:formatNumber var="formattedTotal" type="number" minFractionDigits="2" maxFractionDigits="2" value="${total}" />
                <tr>
                    <th class="w3-text-white">${sum}</th>
                    <th class="w3-text-white">${formattedTotal}$</th>
                </tr>
            </table>
            <br/><br/>
            <div class="w3-container w3-large w3-border w3-border-white  w3-round-xxlarge" style="width: 30%; display: inline-block">
                <div class="w3-center w3-text-white">
                    <h2>${title}</h2>
                </div>
                <form method="post">
                    <label class="w3-text-white">${card}</label>
                    <input class="w3-input w3-border w3-round-large" type="text" name="cardNumb" required/><br/>
                    <label class="w3-text-white">${holder}</label>
                    <input class="w3-input w3-border w3-round-large" type="text" name="name" required/><br/>
                    <label class="w3-text-white">${expdate}</label>
                    <input class="w3-input w3-border w3-round-large" type="text" name="date" required/><br/>
                    <label class="w3-text-white">${CVV}</label>
                    <input class="w3-input w3-border w3-round-large" type="text" name="security" required/><br/>
                    <button class="w3-btn w3-text-white w3-border w3-round-xlarge" style="width: 100%" type="submit" formaction="controller?command=purchase">${purchase}</button>
                </form>
            </div>
        </c:if>
    </div>

    <footer>
        <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
    </footer>
</body>
</html>
