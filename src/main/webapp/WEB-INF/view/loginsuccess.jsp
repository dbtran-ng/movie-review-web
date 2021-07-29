<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movie List</title>

<jsp:include page="/shared/style_import.jsp" />
</head>
<body>

	<jsp:include page="_header.jsp" />
	<section class="movies section">
		<div class="menu d-flex justify-content-start align-items-center">
			<h2 class="title title--white">ALL MOVIES</h2>
			<h2 class="title title--white">SEARCH MOVIES</h2>
		</div>
		<div class="movies__content container">
			<div class="row">
				<c:forEach items="${movies}" var="movie">
					<div class="col-4 movies__col">
						<div class="movies__item">
							<a class="venobox" data-vbtype="video"
								href="${movie.youtubeTrailer}">
								<div class="movies__video">
									<img class="img-fluid" src="${movie.imagePath}" alt="avengers">
									<i class="fa fa-play"></i>
								</div>
							</a>
							<p class="movies__type">${movie.country}<br> <i
									class="fa fa-calendar-alt mx-2"></i> ${movie.year}
							</p>
							<a href="#">${movie.title}</a>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

	</section>

	<jsp:include page="_footer.jsp" />
	<jsp:include page="/shared/scripts_import.jsp" />
</body>
</html>