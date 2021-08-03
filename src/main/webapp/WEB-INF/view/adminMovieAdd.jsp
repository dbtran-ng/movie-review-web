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


	<div class="signup">
		<div class="alert alert-success center" role="alert">
			<p>${NOTIFICATION}</p>
		</div>
		<form action="<%=request.getContextPath()%>/addMovie" method="post">

			<h1>Create a Movie</h1>
			<fieldset>
				<legend>
					<h3>Movie Details</h3>
				</legend>
				<div class="account__details">
					<div>
						<label for="uname">Title</label><input type="text"
							class="form-control" name="title" required>
					</div>
					<div>
						<label for="uname">Country</label><input type="text"
							class="form-control" name="country" required>
					</div>
					<div>
						<label for="uname">Year</label><input type="text"
							class="form-control" name="year" required>
					</div>
					<div>
						<label for="uname">Description</label><input type="text"
							class="form-control" name="description" required>
					</div>
					<div>
						<label for="uname">ImagePath</label><input type="text"
							class="form-control" name="imagePath" required>
					</div>
					<div>
						<label for="uname">YoutubeTrailer</label><input type="text"
							class="form-control" name="youtubeTrailer" required>
					</div>

				</div>
			</fieldset>

			<button type="submit">Submit</button>
			<a style="text-align:center" href="listMovies">Cancel</a>
		</form>
	</div>

	<jsp:include page="/shared/scripts_import.jsp" />
</body>

</html>