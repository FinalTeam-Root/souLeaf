<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>check</title>
</head>
<body>
<c:if test="${loginUser eq null }">
<script type="text/javascript">
alert("로그인하셔야죠");
history.back();
</script>
</c:if>
</body>
</html>