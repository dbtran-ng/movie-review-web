<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>What To Watch</title>

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

    <!-- ANIMATE CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.1.1/animate.min.css" />

    <!-- venobox CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/venobox.min.css">

    <!-- Index CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">

</head>

<body>


    <!-- CAROUSEL -->
    <section class="movieCarousel">
        <!-- data-ride="carousel" -->
        <div id="carouselMovie" class="carousel slide carousel-fade">
            <ol class="container carousel-indicators">
                <li data-target="#carouselMovie" data-slide-to="0" class="active"></li>
                <li data-target="#carouselMovie" data-slide-to="1"></li>
                <li data-target="#carouselMovie" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <!-- <img src="./img/hero-1.jpg" class="d-block w-100" alt="..."> -->
                    <div class="movieCarousel__overlay">
                    </div>
                    <div class="container carousel-caption">
                        <div class="col-12 col-lg-9 p-0">
                            <p class="animate__animated animate__fadeInDown">ACTION, ADVENTURE, FANTASY</p>
                            <h2 class="animate__animated animate__fadeInDown">End of the World: Part I</h2>
                            <p class="animate__animated animate__fadeInUp">Claritas est etiam processus dynamicus, qui
                                sequitur mutationem consuetudium lectorum.
                                Mirum est notare quam littera gothica, quam nunc putamu.</p>
                            <div class="movieCarousel__trailer animate__animated animate__fadeInUp">
                                <span>PG</span>
                                <button class="btn">
                                    <span>
                                        <i class="fa fa-play"></i>
                                        PLAY TRAILER
                                    </span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <!-- <img src="./img/hero-2.jpg" class="d-block w-100" alt="..."> -->
                    <div class="movieCarousel__overlay">
                    </div>
                    <div class="container carousel-caption">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-9 col-xl-9 p-0">
                            <p class="animate__animated animate__fadeInDown">ACTION, ADVENTURE, FANTASY</p>
                            <h2 class="animate__animated animate__fadeInDown">End of the World: Part II</h2>
                            <p class="animate__animated animate__fadeInUp">Claritas est etiam processus dynamicus, qui
                                sequitur mutationem consuetudium lectorum.
                                Mirum
                                est notare quam littera gothica, quam nunc putamu.</p>
                            <div class="movieCarousel__trailer animate__animated animate__fadeInUp">
                                <span>PG</span>
                                <button>
                                    <span>
                                        <i class="fa fa-play"></i>
                                        PLAY TRAILER
                                    </span>

                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <!-- <img src="./img/hero-3.jpg" class="d-block w-100" alt="..."> -->
                    <div class="movieCarousel__overlay">
                    </div>
                    <div class="container carousel-caption">
                        <div class="col-12 col-sm-12 col-md-12 col-lg-9 col-xl-9 p-0">
                            <p class="animate__animated animate__fadeInDown">ACTION, ADVENTURE, FANTASY</p>
                            <h2 class="animate__animated animate__fadeInDown">End of the World: Part III</h2>
                            <p class="animate__animated animate__fadeInUp">Claritas est etiam processus dynamicus, qui
                                sequitur mutationem consuetudium lectorum.
                                Mirum
                                est notare quam littera gothica, quam nunc putamu.</p>
                            <div class="movieCarousel__trailer animate__animated animate__fadeInUp">
                                <span>PG</span>
                                <button>
                                    <span>

                                        <i class="fa fa-play"></i>
                                        PLAY TRAILER
                                    </span>
                                </button>
                            </div>
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
                    <div class="col-6 col-md-3">
                        <div class="newIn__img">
                            <img class="img-fluid" src="./img/movie-1.jpg" alt="">
                            <div class="newIn__overlay"></div>
                            <div class="newIn__play">
                                <div>
                                    <a href="#"><i class="fa fa-play"></i></a>
                                    <a href="#">read more</a>
                                    <p class="date">Released: 7 Mar, 2017</p>
                                </div>

                            </div>
                        </div>
                        <div class="newIn__title mb-3 mb-md-0">
                            <h3>The last post</h3>
                            <div>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-6 col-md-3 col-lg-3 col-xl-3">
                        <div class="newIn__img">
                            <img class="img-fluid" src="./img/movie-2.jpg" alt="">
                            <div class="newIn__overlay"></div>
                            <div class="newIn__play">
                                <div>
                                    <a href="#"><i class="fa fa-play"></i></a>
                                    <a href="#">read more</a>
                                    <p class="date">Released: 7 Mar, 2017</p>
                                </div>
                            </div>
                        </div>
                        <div class="newIn__title mb-3 mb-md-0">
                            <h3>Dark and lonely</h3>
                            <div>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-6 col-md-3 col-lg-3 col-xl-3">
                        <div class="newIn__img">
                            <img class="img-fluid" src="./img/movie-3.jpg" alt="">
                            <div class="newIn__overlay"></div>
                            <div class="newIn__play">
                                <div>
                                    <a href="#"><i class="fa fa-play"></i></a>
                                    <a href="#">read more</a>
                                    <p class="date">Released: 7 Mar, 2017</p>
                                </div>
                            </div>
                        </div>
                        <div class="newIn__title mb-3 mb-md-0">
                            <h3>Venture</h3>
                            <div>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                        </div>
                    </div>
                    <div class="col-6 col-sm-6 col-md-3 col-lg-3 col-xl-3">
                        <div class="newIn__img">
                            <img class="img-fluid" src="./img/movie-4.jpg" alt="">
                            <div class="newIn__overlay"></div>
                            <div class="newIn__play">
                                <div>
                                    <a href="#"><i class="fa fa-play"></i></a>
                                    <a href="#">read more</a>
                                    <p class="date">Released: 7 Mar, 2017</p>
                                </div>
                            </div>
                        </div>
                        <div class="newIn__title mb-3 mb-md-0">
                            <h3>Hush</h3>
                            <div>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                                <i class="fa fa-star"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
  
    </section>
    <!-- COMINGSOON -->
    <section class="comingSoon section">
        <div class="container-md">
            <h2 class="title title--white">COMING SOON</h2>
            <div class="row align-items-center">
                <div class="col-12 col-sm-6">
                    <p class="comingSoon__type">COMEDY, CRIME</p>
                    <h3>The Hangover Part III</h3>
                    <div class="comingSoon__rating">
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <i class="fa fa-star"></i>
                        <span>
                            <i class="fa fa-calendar-alt mx-3"></i>
                            30 Septemper 2020
                        </span>
                    </div>
                    <p>When one of their own is kidnapped by an angry gangster, the Wolf Pack must track down Mr. Chow,
                        who has escaped from prison and is on the run.</p>
                    <a href="#">MORE INFO <i class="fa fa-angle-right"></i></a>
                </div>
                <div class="col-12 col-sm-6 mt-3 mt-sm-0">
                    <a class="venobox" data-vbtype="video" href="https://youtu.be/sL3kLxsy-Lg">
                        <div class="comingSoon__video">
                            <img class="img-fluid" src="./img/slide-3-video.png" alt="">
                            <i class="fa fa-play"></i>
                        </div>
                    </a>

                </div>
            </div>
        </div>
    </section>
    <!-- MOVIELIST -->
    <section class="movieList section">
        <div class="container">
            <div class="row">
                <div class="col-4 col-lg-2 mb-3 mb-lg-0">
                    <div class="movieList__item">
                        <img class="img-fluid" src="./img/movie-9.jpg" alt="">
                        <div class="movieList__overlay"></div>
                    </div>
                </div>
                <div class="col-4 col-lg-2 mb-3 mb-lg-0">
                    <div class="movieList__item">
                        <img class="img-fluid" src="./img/movie-8.jpg" alt="">
                        <div class="movieList__overlay"></div>
                    </div>
                </div>
                <div class="col-4 col-lg-2 mb-3 mb-lg-0">
                    <div class="movieList__item">
                        <img class="img-fluid" src="./img/movie-11.jpg" alt="">
                        <div class="movieList__overlay"></div>
                    </div>
                </div>
                <div class="col-4 col-sm-4 col-md-4 col-lg-2 col-xl-2">
                    <div class="movieList__item">
                        <img class="img-fluid" src="./img/movie-13.jpg" alt="">
                        <div class="movieList__overlay"></div>
                    </div>
                </div>
                <div class="col-4 col-sm-4 col-md-4 col-lg-2 col-xl-2">
                    <div class="movieList__item">
                        <img class="img-fluid" src="./img/movie-12.jpg" alt="">
                        <div class="movieList__overlay"></div>
                    </div>
                </div>
                <div class="col-4 col-sm-4 col-md-4 col-lg-2 col-xl-2">
                    <div class="movieList__item">
                        <img class="img-fluid" src="./img/movie-14.jpg" alt="">
                        <div class="movieList__overlay"></div>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <!-- Jquery -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>

    <!-- BS4 JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
        crossorigin="anonymous"></script>

    <!-- VENOBOX JS     -->
    <script src="${pageContext.request.contextPath}/js/venobox.min.js"></script>
    <script>
        $(document).ready(function () {
            $('.venobox').venobox();
        });
    </script>

    <!-- MAIN JS -->
    <script>

        window.onscroll = function () {
            if (document.body.scrollTop > 200 || document.documentElement.scrollTop > 200) {
                // translate(-50%,0)
                document.getElementById("headerFixed").style.transform = "translate(-50%,0)";
            } else {
                document.getElementById("headerFixed").style.transform = "translate(-50%,-100%)";
            }
        }
    </script>
</body>

</html>