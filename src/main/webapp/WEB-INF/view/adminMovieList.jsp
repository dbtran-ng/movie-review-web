<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Movie Management</title>
<jsp:include page="/shared/style_import.jsp" />
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="listMovies">List Movies <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="addMovie">Add
						Movie</a></li>
				<li class="nav-item"><a class="nav-link" href="home">Log
						Out of Admin Page</a></li>
			</ul>
		</div>
	</nav>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Movies</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/addMovie"
					class="btn btn-success">Add New Movie</a>
			</div>
			<br>


			<div class="table-responsive">

				<table class="table table-sm table-hover table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Country</th>
							<th>Year</th>
							<th>Description</th>
							<th>Image Path</th>
							<th>Youtube Trailer</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${movies}" var="movie">

							<tr>
								<td>${movie.movieId}</td>
								<td>${movie.title}</td>
								<td>${movie.country}</td>
								<td>${movie.year}</td>
								<td>${movie.description}</td>
								<td>${movie.imagePath}</td>
								<td>${movie.youtubeTrailer}</td>
								<td><a href="editMovie?movieId=${movie.movieId}" />Edit</a> <a
									href="deleteMovie?movieId=${movie.movieId}">Delete</a></td>
							</tr>
						</c:forEach>

					</tbody>

				</table>


			</div>

		</div>
	</div>

	<jsp:include page="/shared/scripts_import.jsp" />
</body>
</html>