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


	<h3>Movies List</h3>


	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Movie ID</th>
			<th>Title</th>
			<th>Country</th>
			<th>Year</th>
			<th>Description</th>
			<th>ImagePath</th>
			<th>YoutubeTrailer</th>
		</tr>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td>${movie.movieId}</td>
				<td>${movie.title}</td>
				<td>${movie.country}</td>
				<td>${movie.year}</td>
				<td>${movie.description}</td>
				<td>${movie.imagePath}</td>
				<td>${movie.youtubeTrailer}</td>
			</tr>
		</c:forEach>
	</table>

	<section>
		<div>
			<c:forEach items="${movies}" var="movie">
				            <div class="row align-items-center">
                <div class="col-12 col-sm-6">
                    <h3>${movie.title}</h3>
                    <div class="comingSoon__rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <span>
                            <i class="fa fa-calendar-alt mx-3"></i>
                            ${movie.year}
                        </span>
                    </div>
                    <p>${movie.description}</p>
                    <a href="#">MORE INFO <i class="fa fa-angle-right"></i></a>
                </div>
                <div class="col-12 col-sm-6 mt-3 mt-sm-0">
                    <a class="venobox" data-vbtype="video" href="${movie.youtubeTrailer}">
                        <div class="comingSoon__video">
                            <img class="img-fluid" src="${movie.imagePath}" alt="">
                            <i class="fa fa-play"></i>
                        </div>
                    </a>

                </div>
            </div>
			</c:forEach>
		</div>

	</section>


	<jsp:include page="/shared/scripts_import.jsp" />
</body>
</html>