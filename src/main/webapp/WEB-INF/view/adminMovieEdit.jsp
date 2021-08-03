<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add Movie</title>

<jsp:include page="/shared/style_import.jsp" />
</head>

<body>


	<h3>Edit Movie</h3>
	<p style="color: red;">${errorString}</p>
	<p>Information of Movie</p>
	<c:if test="${not empty movie}">
		<form action="<%=request.getContextPath()%>/editMovie" method="post">
			<input type="hidden" name="reviewId" value="${movie.movieId}" />
			<table border="0">
				<tr>
					<td>Movie Id</td>
					<td style="color: red;"><input type="text" name="movieId"
						value="${movie.movieId}" readonly /></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title" value="${movie.title}" /></td>
				</tr>
				<tr>
					<td>Country</td>
					<td><input type="text" name="country" value="${movie.country}" /></td>
				</tr>
				<tr>
					<td>Year</td>
					<td><input type="text" name="year" value="${movie.year}" /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><input type="text" name="description"
						value="${movie.description}" /></td>
				</tr>
				<tr>
					<td>ImagePath</td>
					<td><input type="text" name="imagePath"
						value="${movie.imagePath}" /></td>
				</tr>
				<tr>
					<td>Youtube Trailer</td>
					<td><input type="text" name="youtubeTrailer"
						value="${movie.youtubeTrailer}" /></td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit"
							class="buttonAdd btn btn-success">Submit</button> <a
						href="listMovies">Cancel</a></td>
				</tr>
			</table>
		</form>
	</c:if>

</body>

</html>