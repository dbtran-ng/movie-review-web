<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
	
	<jsp:include page="/shared/style_import.jsp" />
</head>

<body>

    <header>
        <nav class="navInstruction navbar navbar-expand-lg container">
            <a class="navbar-brand" href="#">
                <img src="./img/logo.svg" alt="logo">
                <p>What to Watch</p>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarInstruction"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fa fa-bars"></i>
            </button>
            <div class="collapse navbar-collapse" id="movieNavBar">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item line">
                        <a class="nav-link" href="home">HOME</a>
                    </li>
                    <li class="nav-item line">
                        <a class="nav-link" href="login">SIGN IN</a>
                    </li>
                    <li class="nav-item active line">
                        <a class="nav-link" href="register">REGISTER</a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <div class="signup">
		<div class="alert alert-success center" role="alert">
				<p>${NOTIFICATION}</p>
		</div>
        <form action="<%=request.getContextPath()%>/register" method="post">

            <h1>Create a free account</h1>
            <fieldset>
                <legend>
                    <h3>Account Details</h3>
                </legend>
                <div class="account__details">
                    <div><label for="uname">Email*</label><input type="text" class="form-control" id="email"  name="email" required></div>
                    <div><label for="uname">User Name*</label><input type="text" class="form-control" id="username"  name="username" required></div>
                    <div>
                   		<label for="uname">Password*</label><input type="password"
							class="form-control" id="password" placeholder="Password"
							name="password" required>
					</div>
                    <div>
                    	<label for="uname">Repeat password*</label><input type="password"
							class="form-control" id="repassword" placeholder="Password"
							name="password" required>
					</div>
                </div>
            </fieldset>
            <fieldset>
                <legend>
                    <h3>Personal Details</h3>
                </legend>
                <div class="personal__details">
                    <div>
                        <div><label>First Name*</label><input type="text" id="firstname"  name="firstname" required></div>
                        <div><label>Last Name*</label><input type="text" type="text" id="lastname"  name="lastname" required></div>
                        <div><label>Address</label><input type="text" type="text" id="addres"  name="address"></div>
                        <div><label>State</label><input type="text"type="text" id="state"  name="state" required></div>
                    </div>
                </div>
            </fieldset>
            <fieldset>
                <div class="terms">
                    <div class="checkbox">
                        <input type="checkbox" name="checkbox"><span>I accept the <a
                                href="#">Privacy Policy for WhatToWatch.</a></span>
                    </div>
            </fieldset>
            <button type="submit" href="login">Submit</button>
        </form>
    </div>

	<jsp:include page="/shared/scripts_import.jsp" />
</body>

</html>