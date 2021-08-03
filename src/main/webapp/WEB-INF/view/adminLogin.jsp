<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login</title>
<jsp:include page="/shared/style_import.jsp" />
</head>
<body>
	<header>
		<nav class="navInstruction navbar navbar-expand-lg container">
			<a class="navbar-brand" href="#"> <img src="./img/logo.svg"
				alt="logo">
				<p>What to Watch</p>
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarInstruction" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="movieNavBar">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item line"><a class="nav-link" href="home">HOME</a>
					</li>
					<li class="nav-item line"><a class="nav-link" href="login">Switch
							To User LOG IN</a></li>
					<li class="nav-item line"><a class="nav-link"
						href="register">Switch to User SIGN UP</a></li>
					<li class="nav-item active line"><a class="nav-link"
						href="admin">ADMIN</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<h3>Login Page</h3>
	<p style="color: red;">${errorString}</p>


	<form method="POST" action="${pageContext.request.contextPath}/admin">
		<table border="0">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="admin_username"
					value="${admin.username}" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="admin_password"
					value="${admin.password}" /></td>
			</tr>
			<tr>
				<td>Remember me</td>
				<td><input type="checkbox" name="rememberMe" value="Y" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <a
					href="${pageContext.request.contextPath}/admin">Cancel</a></td>
			</tr>
		</table>
	</form>
	<jsp:include page="/shared/scripts_import.jsp" />
</body>
</html>