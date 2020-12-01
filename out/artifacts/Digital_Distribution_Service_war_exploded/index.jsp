<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<html>
  <head>
    <title>Welcome to Steam Ripoff</title>
  </head>
  <body>
    <!-- header & navigation -->
    <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    <c:if test="${param.message == 'regsuccess'}">
      <h2>Registration successful</h2>
    </c:if>
    <!-- list of games -->
    <div>

    </div>

    <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>

  </body>
</html>
