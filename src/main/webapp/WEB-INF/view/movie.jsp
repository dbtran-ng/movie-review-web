<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reviews of Movie</title>
<!-- FONT GOOGLE -->
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300;400;700&display=swap"
	rel="stylesheet">

<!-- FONT AWESOME -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
	integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
	crossorigin="anonymous" />

<!-- BS4 CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<!-- ANIMATE CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

<!-- venobox CSS -->
<link rel="stylesheet" href="./css/venobox.min.css">

<!-- Index CSS -->
<link rel="stylesheet" href="./css/home.css">
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<c:if test="${not empty movie}">
		<form method="GET" action="${pageContext.request.contextPath}/movie">
			<input type="hidden" name="movieId" value="${movie.movieId}" />
			<section class="movies section">
				<div class="container-md">
					<div class="movies__header d-inline-flex p-2">
						<p style="color: red;">${errorString}</p>
						<a href="${pageContext.request.contextPath}/movies">
							<h2 class="title title--white">ALL MOVIES</h2>
						</a>
					</div>
					<div class="movie">
						<div class="movie__details row align-items-center">
							<div class="col-12 col-sm-6 mt-3 mt-sm-0">
								<a class="venobox" data-vbtype="video"
									href="${movie.youtubeTrailer}">
									<div class="moviedetails__video">
										<img class="img-fluid" src="${movie.imagePath}" alt="image">
										<i class="fa fa-play"></i>
									</div>
								</a>


							</div>
							<div class="col-12 col-sm-6">
								<p class="moviedetails__type">${movie.country}</p>
								<h3>${movie.title}</h3>
								<div class="moviedetails__rating">
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <span> <i
										class="fa fa-calendar-alt mx-3"></i> ${movie.year}
									</span>
								</div>
								<p>${movie.description}</p>
								<a href="#">MORE INFO <i class="fa fa-angle-right"></i></a>
							</div>
						</div>
						<div class="movie__review">
							<div class="review">
								<h3>User Review</h3>
								<c:forEach items="${reviews}" var="review">
									<div class="review__details">
										<h2>
											From <b>${review.authorName}</b>
										</h2>
										<h4>${review.title}</h4>
										<p>${review.description}</p>
										<a href="editReview?reviewId=${review.reviewId}">Edit</a> | <a
											href="deleteReview?reviewId=${review.reviewId}"> Delete</a>
									</div>
								</c:forEach>
								<a href="review?movieId=${movie.movieId}"
									class="buttonAdd btn btn-success">Add a Review</a>
							</div>
						</div>
					</div>

				</div>
				<br> <br> <br>
			</section>
		</form>
	</c:if>

	<jsp:include page="_footer.jsp"></jsp:include>
	<jsp:include page="/shared/scripts_import.jsp" />

</body>
</html>