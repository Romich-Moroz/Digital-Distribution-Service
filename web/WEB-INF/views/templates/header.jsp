<%--suppress ELValidationInJSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <button onclick="location.href='controller?command=mainredirect'">Home</button>
    <button onclick="location.href='controller?command=storeredirect'">Store</button>
    <c:choose>
        <c:when test="${user != null}">
            <button onclick="location.href='controller?command=gamesredirect'">Games</button>
            <button onclick="location.href='controller?command=cartredirect'">Cart</button>
            <c:if test="${user.access.type == 'admin'}">
                <button onclick="location.href='controller?command=cateditredirect'">Edit catalog</button>
                <button onclick="location.href='controller?command=blacklistredirect'">Blacklist</button>
            </c:if>
            Welcome,  <c:out value = "${user.login}"/>
            <button onclick="location.href='controller?command=logout'">Logout</button>
        </c:when>
        <c:otherwise>
            <button onclick="location.href='controller?command=authredirect'">Login</button>
        </c:otherwise>
    </c:choose>


</div>
