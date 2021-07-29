<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In</title>
    <!-- FONT GOOGLE -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:wght@300;400;700&display=swap"
        rel="stylesheet">

    <!-- FONT AWESOME -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
        integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
        crossorigin="anonymous" />
    <!-- BS4 CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
            integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        
 
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>

<body>

    <header>
        <nav class="navbar navbar-expand-md px-0">
            <a class="navbar-brand" href="#">
                <img src="./img/logo.svg" alt="logo">
                <p>What to Watch</p>
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#movieNavBar"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon">
                    <i class="fa fa-bars"></i>
                </span>
            </button>
            <div class="collapse navbar-collapse" id="movieNavBar">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active line">
                        <a class="nav-link" href="#">HOME</a>
                    </li>
                    <li class="nav-item line">
                        <a class="nav-link" href="<%= request.getContextPath() %>/login">SIGN IN</a>
                    </li>
                     <li class="nav-item line">
                        <a class="nav-link" href="<%= request.getContextPath() %>/register">SIGN UP</a>
                    </li>
                </ul>
          
            </div>
        </nav>
    </header>
    <div class="login">
        <form action="<%=request.getContextPath()%>/login" method="post">
            <h1>Log in to your account</h1>
            <fieldset>
                <legend>
                    <h3>Account Details</h3>
                </legend>
                <div class="account__details">
                
                    <div><label>Username*</label><input type="text"name="user_name" value="${login.username}" required></div>
                    <div><label>Password*</label><input type="password" name="user_password" value="${login.password}" required></div>
    
                </div>
            </fieldset>
            <fieldset>
                <div class="terms">
                    <div class="checkbox">
                        <input type="checkbox" name="rememberMe" value ="Y"/> Remember me
                    </div>
            </fieldset>
            <button type="submit" href="/">Submit</button>
        </form>
    </div>

        <!-- Jquery -->
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

        <!-- BS4 JS -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    
</body>

</html>