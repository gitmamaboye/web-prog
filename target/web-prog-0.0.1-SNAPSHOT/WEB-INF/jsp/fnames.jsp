<%--
  Created by IntelliJ IDEA.
  User: mamaboye
  Date: 12.06.20
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alle Vornamen</title>
</head>
<body>
<c:forEach var="entry" items="${it}">
  <p>${entry}</p>
</c:forEach>
</body>
</html>
