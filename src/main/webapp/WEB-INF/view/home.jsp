<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home</title>

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

	<!-- HEADER -->
	<header class="container-md">

		<nav class="navbar navbar-expand-md px-0">
			<a class="navbar-brand" href="#"> <img src="./img/logo.svg"
				alt="logo">
				<p>What to Watch</p>
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#movieNavBar" aria-controls="navbarSupportedContent"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"> <i class="fa fa-bars"></i>
				</span>
			</button>

			<div class="collapse navbar-collapse" id="movieNavBar">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active line"><a class="nav-link"
						href="home">Home</a></li>
					<li class="nav-item line"><a class="nav-link" href="login">Log
							In</a></li>
					<li class="nav-item line"><a class="nav-link" href="register">Sign
							Up</a></li>
					<li class="nav-item line"><a class="nav-link" href="admin">Admin</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<header id="headerFixed">
		<nav class="navbar container navbar-expand-md">
			<a class="navbar-brand" href="#"> <img src="./img/logo.svg"
				alt="logo">
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#movieNavBar" aria-controls="navbarSupportedContent"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"> <i class="fa fa-bars"></i>
				</span>
			</button>

			<div class="collapse navbar-collapse" id="movieNavBar">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active line"><a class="nav-link"
						href="home">Home</a></li>
					<li class="nav-item line"><a class="nav-link" href="login">Log
							In</a></li>
					<li class="nav-item line"><a class="nav-link" href="signup">Sign
							Up</a></li>
					<li class="nav-item line"><a class="nav-link" href="admin">Admin</a>
					</li>
				</ul>
			</div>
		</nav>
	</header>
	<!-- CAROUSEL -->
	<section class="movieCarousel">
		<div id="carouselMovie" class="carousel slide carousel-fade">
			<ol class="container carousel-indicators">
				<li data-target="#carouselMovie" data-slide-to="0" class="active"></li>
				<li data-target="#carouselMovie" data-slide-to="1"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="./img/hero-1.jpg" class="d-block w-100" alt="...">
					<div class="movieCarousel__overlay"></div>
					<div class="container carousel-caption">
						<div class="col-12 col-lg-9 p-0">
							<h2 class="animate__animated animate__fadeInDown">Sign Up to
								Get Started</h2>
							<p class="animate__animated animate__fadeInUp">What to Watch
								provides the best user generated reviews on movies to make your
								choices simple to choose a movie.</p>
						</div>
					</div>
				</div>
				<div class="carousel-item">
					<img src="./img/hero-3.jpg" class="d-block w-100" alt="...">
					<div class="movieCarousel__overlay"></div>
					<div class="container carousel-caption">
						<div class="col-12 col-sm-12 col-md-12 col-lg-9 col-xl-9 p-0">
							<h2 class="animate__animated animate__fadeInDown">Latest
								Movie Reviews</h2>
							<p class="animate__animated animate__fadeInUp">What to Watch
								is your source for movie reviews and movie ratings to help
								maximize your movie-going-experience. Our easy to use movie
								reviews and movie ratings are based on opinions from respected
								movie critics, family advocacy groups and movie fans like you.</p>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!-- NEWIN -->
	<section class="newIn section">
		<div class="container">
			<h2 class="title">Just Added</h2>
			<div class="newIn__content">
				<div class="row">
					<c:forEach items="${movies}" var="movie">
						<div class="col-6 col-md-3">
							<div class="newIn__img">
								<img class="img-fluid" src="${movie.imagePath}" alt="">
								<div class="newIn__overlay"></div>
								<div class="newIn__play">
									<div>
										<a href="#"><i class="fa fa-play"></i></a> <a href="#">read
											more</a>
										<p class="date">${movie.year}</p>
									</div>

								</div>
							</div>
							<div class="newIn__title mb-3 mb-md-0">
								<h3>${movie.title}</h3>
								<div>
									<i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i> <i class="fa fa-star"></i> <i
										class="fa fa-star"></i>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="/shared/scripts_import.jsp" />
</body>
</html>