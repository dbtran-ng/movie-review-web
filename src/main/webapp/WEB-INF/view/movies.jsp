<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tags:general title="movie">
    <div class="section pl-3 mt-2">
        <div class="movie-list text-light p-2 row">
            <c:forEach var="movie" items="${requestScope.movies}">
                <div class="movie-item m-1 p-1 col-sm">
                    <a href="${pageContext.request.contextPath}/movie.do?movieId=${movie.id}">
                    <div class="movie-image-container movie-holder">
                            <div class="movie-block">
                                <h4 align="center">  ${movie.rating} <span style="color: yellow">&#9733;</span></h4>
                            </div>
                            <div class="movie-image-cover"></div>
                            <img class="movie-item__image" src="${movie.imagePath}" alt="Image">
                    </div>
                    <div class="movie-item__info">
                            <h3>${movie.title}</h3>
                            <h6>${movie.country}, ${movie.year}</h6>
                      
                    </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="page-container">
        <div class="prev-page-container mt-2 mb-4">
            <a href="${requestScope.prevPageHref}" class="btn btn-primary"><fmt:message key="PrevPage"/></a>
        </div>
        <div class="next-page-container mt-2 mb-4">
            <a href="${requestScope.nextPageHref}" class="btn btn-primary"><fmt:message key="NextPage"/></a>
        </div>
    </div>

</tags:general>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/select.js"></script>