<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Review</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<h3>Edit Review</h3>
	<p style="color: red;">${errorString}</p>
	<p>Information of Review</p>
	<c:if test="${not empty review}">
		<form action="<%=request.getContextPath()%>/editReview" method="post">
			<input type="hidden" name="reviewId" value="${review.reviewId}" />
			<table border="0">
				<tr>
					<td>Movie Id </td>
					<td style="color: red;"><input type="text" name="movieId"
						value="${review.movieId}" readonly/></td>
				</tr>
				<tr>
					<td>Author name</td>
					<td><input type="text" name="authorName"
						value="${review.authorName}" readonly/></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" value="${review.title}" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description" value="${review.description}" /></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit"
						class="buttonAdd btn btn-success">Submit</button> <a
						href="movie?movieId=${review.movieId}">Cancel</a></td>
				</tr>
			</table>
		</form>
	</c:if>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>