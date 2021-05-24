<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>souLeaf - 솔리프</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" sizes="16x16"  href="resources/images/favicon-16x16.png">
    <meta name="msapplication-TileColor" content="#ffffff">
	<meta name="theme-color" content="#ffffff">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap" rel="stylesheet">

    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet"> <!--CDN 링크 -->
    <link rel="stylesheet" href="resources/css/animate.css">
    
    <link rel="stylesheet" href="resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="resources/css/magnific-popup.css">


    <link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="resources/css/jquery.timepicker.css">

    <link rel="stylesheet" href="resources/css/flaticon.css">
    <link rel="stylesheet" href="resources/css/style.css">
 </head>
  <body>

    <div class="wrap">
			<div class="container">
				<div class="row">
					<div class="col-md-6 d-flex align-items-center">
						<p class="mb-0 phone pl-md-2">
							<a href="#" class="mr-2"><span class="fas fa-map-marker-alt mr-1"></span> 서울시 종로구</a>
							<a href="#" class="mr-2"><span class="fa fa-cloud-sun mr-1"></span> 맑음</a>
							<a href="#"><span class="fas fa-temperature-low mr-1"></span> 30°C</a>
						</p>
					</div>
					<div class="col-md-6 d-flex justify-content-md-end">
						<div class="login-media">
				    		<p class="mb-0 d-flex">
				    			<c:if test="${loginUser eq null }">
					    			<a href="loginView.kh" class="d-flex align-items-center justify-content-center"><span class="fas fa-sign-in-alt"> 로그인</span></a>
				    			</c:if>
				    			<c:if test="${loginUser ne null }">
					    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fas fa-comments" id="head-chat"> 채팅</span></a>
					    			<a href="diaryMainView.kh?memberNo=${loginUser.memberNo }" class="d-flex align-items-center justify-content-center"><span class="fas fa-leaf" id="head-leaf"> 성장일기</span></a>
					    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fas fa-user" id="head-mypage"> 마이페이지</span></a>
					    			<a href="logout.kh" class="d-flex align-items-center justify-content-center"><span class="fas fa-sign-out-alt" id="head-logout"> 로그아웃</span></a>
				    			</c:if>
				    		</p>
		       			</div>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	    	<a class="navbar-brand" href="/home.kh"><img src="resources/images/logo.png" width="200"></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="fa fa-bars"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
		        	<li class="nav-item <c:if test="${nav eq 'home' }">active</c:if>"><a href="home.kh" class="nav-link">홈</a></li>
					<li class="nav-item <c:if test="${nav eq 'intro' }">active</c:if>"><a href="intro.kh" class="nav-link">이야기</a></li>
					<li class="nav-item <c:if test="${nav eq 'plant' }">active</c:if>"><a href="plantListView.kh" class="nav-link">식물찾기</a></li>
					<li class="nav-item <c:if test="${nav eq 'boast' }">active</c:if>"><a href="boastListView.kh" class="nav-link">식물자랑</a></li>
					<li class="nav-item <c:if test="${nav eq 'clinic' }">active</c:if>"><a href="#" class="nav-link">식물클리닉</a></li>
					<li class="nav-item <c:if test="${nav eq 'curiosity' }">active</c:if>"><a href="#" class="nav-link">궁금해요</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
</body>
</html>