<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reviews of Movie</title>
<jsp:include page="/shared/style_import.jsp" />
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<p style="color: red;">${errorString}</p>
	<form method="GET"
		action="${pageContext.request.contextPath}/searchMovie">
		<div class="row">
			<c:if test="${not empty movies}">
				<c:forEach items="${movies}" var="movie">
					<input type="hidden" name="movieId" value="${movie.movieId}" />
					<div class="col-4 movies__col">
						<div class="movies__item">
							<a class="venobox" data-vbtype="video"
								href="${movie.youtubeTrailer}">
								<div class="movies__video">
									<img class="img-fluid" src="${movie.imagePath}" alt="avengers">
									<i class="fa fa-play"></i>
								</div>
							</a>
							<div class="movies__type">
								<p>${movie.country}<br> <i
										class="fa fa-calendar-alt mx-2"></i> ${movie.year}
								</p>
								<a href="movie?movieId=${movie.movieId}">${movie.title}</a>
							</div>

						</div>
					</div>
				</c:forEach>
			</c:if>
		</div>
	</form>


	<jsp:include page="_footer.jsp"></jsp:include>
	<jsp:include page="/shared/scripts_import.jsp" />

</body>
</html>