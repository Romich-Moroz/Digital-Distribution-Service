<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <style><%@include file="/WEB-INF/css/w3.css"%></style>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="locale" var="loc" />

    <fmt:message bundle="${loc}" key="locale.index.title" var="title" />
    <fmt:message bundle="${loc}" key="locale.index.welcome" var="welcome" />
    <fmt:message bundle="${loc}" key="locale.index.feat1" var="feat1" />
    <fmt:message bundle="${loc}" key="locale.index.feat2" var="feat2" />
    <fmt:message bundle="${loc}" key="locale.index.feat3" var="feat3" />
    <fmt:message bundle="${loc}" key="locale.index.feat4" var="feat4" />
    <fmt:message bundle="${loc}" key="locale.index.feat5" var="feat5" />
    <fmt:message bundle="${loc}" key="locale.index.feat6" var="feat6" />
    <fmt:message bundle="${loc}" key="locale.index.login" var="login" />

    <title>${title}</title>
  </head>
  <body>
    <header>
      <jsp:include page="/WEB-INF/views/templates/header.jsp" />
    </header>

    <div class="content w3-center" style="width: 100%">
      <div class="w3-large" style="width: 30%; display: inline-block">
        <h2 class="w3-text-white">${welcome}</h2>
        <ul class="w3-text-white w3-ul">
          <li>${feat1}</li>
          <li>${feat2}</li>
          <li>${feat3}</li>
          <li>${feat4}</li>
          <li>${feat5}</li>
          <li>${feat6}</li>
        </ul>
        <h2 class="w3-text-white w3-center">${login}</h2>
      </div>
    </div>


    <footer>
      <jsp:include page="/WEB-INF/views/templates/footer.jsp"/>
    </footer>
  </body>
</html>
