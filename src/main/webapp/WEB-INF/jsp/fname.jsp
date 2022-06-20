<%--
  Created by IntelliJ IDEA.
  User: mamaboye
  Date: 12.06.20
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<c:forEach var="entry" items="${it}">
<ul>
  <li>  ${entry.firstname} </li>
    <li>  ${entry.lastname} </li>
    <li>  ${entry.residence} </li>
</ul>
</c:forEach>

</body>
</html>
