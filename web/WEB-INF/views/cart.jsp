<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make an order</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    <div>
        <c:if test="${param.message == 'delfromcartexception'}">
            <h2>Failed to remove game from cart</h2>
        </c:if>
        <c:if test="${param.message == 'delfromcartsuccess'}">
            <h2>Removed game to cart</h2>
        </c:if>

        <c:set var="total" value="${0}"/>
        <c:forEach items="${cart}" var="game">
            <div>
                <c:out value = "${game.name} for ${game.price}$"/>
                <c:set var="total" value="${total + game.price}" />
                <button onclick="location.href='controller?command=delfromcart&idGame=${game.id}'">Remove</button><br/>
            </div>
        </c:forEach>
        <fmt:formatNumber var="formattedTotal" type="number" minFractionDigits="2" maxFractionDigits="2" value="${total}" />
        <c:out value="Total: ${formattedTotal}$"/>
        <br/><br/>

        <form method="post">
            <label>
                Card number:&nbsp;
                <input type="text" name="cardNumb"/>
            </label>
            <br/>
            <label>
                Cardholder name:&nbsp;
                <input type="text" name="name"/>
            </label>
            <br/>
            <label>
                Issue date:&nbsp;
                <input type="text" name="date"/>
            </label>
            <br/>
            <label>
                Security numbers:&nbsp;
                <input type="text" name="security"/>
            </label>
            <br/>
            <button type="submit" formaction="controller?command=purchase">Purchase</button>
        </form>


    </div>
    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
</body>
</html>
