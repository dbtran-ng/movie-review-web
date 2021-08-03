<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>What To Watch</title>

<jsp:include page="/shared/style_import.jsp" />

</head>

<body>

	<!-- HEADER -->
	<header class="container-fluid">


		<div class="search__form d-flex flex-row-reverse align-items-center">
			<div class="search__bar">
				<form class="form-inline" method="post"
					action="<%=request.getContextPath()%>/searchMovie">
					<div class="form-group mx-sm-3 mb-2">
						<input type="text" name="title" placeholder="Search any movies" />
					</div>
					<div class="search__button">
						<button type="submit" class="btn btn-primary mb-2">Search</button>
					</div>

				</form>
			</div>


		</div>


		<nav class="navbar navbar-expand-md px-0">
			<a class="navbar-brand" href="movies"> <img src="./img/logo.svg"
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
						href="<%=request.getContextPath()%>/movies">HOME</a></li>
					<li class="nav-item line"><a class="nav-link" href="#">Hello
							<b>${loginedUser.username}
					</a></li>
					<li class="nav-item line"><a class="nav-link"
						href="<%=request.getContextPath()%>/home">LOG OUT</a></li>
				</ul>

			</div>
		</nav>
	</header>


	<jsp:include page="/shared/scripts_import.jsp" />
</body>

</html>