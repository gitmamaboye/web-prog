<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="entry" items="${it}">
    <p>${entry}</p>
</c:forEach>
</body>
</html>
