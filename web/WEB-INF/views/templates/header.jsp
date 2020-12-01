<%--suppress ELValidationInJSP --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>

    <c:if test="${user.access.type == 'admin'}">
        <button onclick="location.href='controller?command=cateditredirect'">Edit catalog</button>
        <button onclick="location.href='controller?command=blacklistredirect'">Blacklist</button>
    </c:if>
    <c:choose>
        <c:when test="${user == null}">
            <button onclick="location.href='controller?command=authredirect'">Login</button>
        </c:when>
        <c:otherwise>
            <h2>Welcome,  <c:out value = "${user.login}"/></h2>
            <button onclick="location.href='controller?command=logout'">Logout</button>
        </c:otherwise>
    </c:choose>


</div>
