<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Review</title>
</head>

<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<h3>Delete Review</h3>
	<form method="GET"
		action="${pageContext.request.contextPath}/deleteReview">
		<p style="color: red;">${errorString}</p>
		<a href="movies"> Come back to List of Movies</a>
		<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>