<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review of Movie</title>


<jsp:include page="/shared/style_import.jsp" />
</head>
<body>

	<h3>Create Review</h3>
	<p style="color: red;">${errorString}</p>
	<c:if test="${not empty movie}">
		<input type="hidden" name="movidId" value="${movie.movieId}" />
		<table border="0">
			<tr>
				<td>Movie Id - Add Review</td>
				<td style="color: red;">${movie.movieId}</td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title" value="${movie.title}" /></td>
			</tr>
		</table>
		<form action="<%=request.getContextPath()%>/review" method="post">
			<table border="0">
				<tr>
					<td>Movie</td>
					<td><input type="text" name="movieId" value="${movie.movieId}"
						required /></td>
				</tr>
				<tr>
					<td>Username Post This Comment</td>
					<td><input type="text" name="username"
						value="${loginedUser.username}" /></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title"
						value="<c:out value='${review.title}' />" required /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description"
						value="<c:out value='${review.description}' />" required /></td>
				</tr>
				<tr>
					<td><button type="submit""
						class="buttonAdd btn btn-success">Submit</button><a
						href="${pageContext.request.contextPath}/movies">Cancel</a></td>
				</tr>
			</table>
		</form>
	</c:if>
</body>
</html>