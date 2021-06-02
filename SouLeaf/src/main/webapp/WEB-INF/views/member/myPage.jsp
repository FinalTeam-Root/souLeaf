<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/qna/qnalist.css">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>souLeaf - 마이페이지</title>
<link rel="icon" type="image/png" sizes="16x16"
	href="resources/images/favicon-16x16.png">
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--     <script src='resources/js/jquery-3.2.1.min.js'></script> -->
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="theme-color" content="#ffffff">
<style>
.nav-tabs>li {
	float: left;
	margin-bottom: -1px;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover
	{
	color: #555;
	cursor: default;
	background-color: #fff;
	border: 1px solid #ddd;
	border-bottom-color: transparent;
}

.nav-tabs>li>a {
	margin-right: 2px;
	line-height: 1.42857143;
	border: 1px solid transparent;
	border-radius: 4px 4px 0 0;
}

.nav>li>a {
	position: relative;
	display: block;
	padding: 10px 15px;
}

.single_what_we_do {
	width: 100%;
	height: 150px;
	border: 1px solid #E7E7E7;
	background-color: #ffffff;
	text-align: center;
	padding: 0 35px;
	border-radius: 10px;
	position: relative;
	margin-bottom: 30px;
	-webkit-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
	cursor: pointer;
}

.single_what_we_do:hover {
	-webkit-box-shadow: 0 8px 12px 0 rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0 8px 12px 0 rgba(0, 0, 0, 0.2);
	box-shadow: 0 8px 12px 0 rgba(0, 0, 0, 0.2);
}

.single_what_we_do .top_line {
	position: absolute;
	top: 0;
	left: 4.5%;
	background-color: #00bd56;
	width: 12%;
	height: 3px;
}

.leftFont {
	text-align: left;
}

.single_what_we_do .what_we_do_icon {
	position: absolute;
	bottom: 57px;
	left: 88%;
	color: #fff;
	background-color: #00bd56;
	width: 30px;
	height: 30px;
	text-align: center;
	border-radius: 50%;
	-webkit-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

.single_what_we_do .what_we_do_icon i {
	font-size: 24px;
	text-align: center;
	padding: 2px 3px 2px 5px;
}
</style>
</head>
<body>
	<div class="container bootstrap snippet">
		<br> <br>
		<div class="row">
			<div class="col-sm-3" style="margin-top: 20px;">
				<!--left col-->
				<div class="col-sm-10">
					<h4>User nick 님</h4>
				</div>
				<div class="text-center">
					<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png" class="avatar img-circle img-thumbnail" alt="avatar" style="width: 100%; height: 230px;"> <br> 
				</div>
				<br>
				<div class="card" style="width: 16rem;">
					<div class="card-header">소개글</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">안녕하세요~! 저는 식물을 사랑하는 사람입니다.</li>
					</ul>

				</div>
				<br>
				<div class="card" style="width: 16rem;">
					<div class="card-header">반려식물</div>
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb"
							style="margin-bottom: -; margin-bottom: 0px; background-color: white;">
							<li class="breadcrumb-item"><a href="#">#Home</a></li>
							<li class="breadcrumb-item"><a href="#">#Library</a></li>
							<li class="breadcrumb-item"><a href="#">#Data</a></li>
						</ol>
					</nav>
				</div>
				<br>
			</div>
			<!--/col-3-->
			<div class="col-sm-9">
				<br>
				<div class="tab-content" id="myTabContent">
					<div class="tab-pane fade show active" id="member" role="tabpanel"
						aria-labelledby="member-tab">
						<div class="container">
							<div class="row">
								<div class="single_what_we_do leftFont"
									onclick="location.href='memerModifyView.kh'">
									<div class="top_line"></div>
									<br>
									<h4 class="what_we_do_title">기본 정보</h4>
									<div class="what_we_do_content">프로필 사진, 이름, 이메일, 휴대전화 정보를
										수정합니다.</div>
									<a class="what_we_do_icon" href="#"> <i
										class="fa fa-angle-right" aria-hidden="true"></i>
									</a>
								</div>
							</div>
							<div class="row">
								<div class="single_what_we_do leftFont"
									onclick="location.href='companionListView.kh'">
									<div class="top_line"></div>
									<br>
									<h4 class="what_we_do_title">반려 식물 정보</h4>
									<div class="what_we_do_content">반려식물 애칭, 이미지를 수정합니다.</div>
									<a class="what_we_do_icon" href="#"> <i
										class="fa fa-angle-right" aria-hidden="true"></i>
									</a>
								</div>
							</div>
							<div class="row">
								<div class="single_what_we_do leftFont"
									onclick="location.href='#'">
									<div class="top_line"></div>
									<br>
									<h4 class="what_we_do_title">내 게시글 관리</h4>
									<div class="what_we_do_content">작성한 게시글을 관리합니다.</div>
									<a class="what_we_do_icon" href="#"> <i
										class="fa fa-angle-right" aria-hidden="true"></i>
									</a>
								</div>
							</div>
							<div class="row">
								<div class="single_what_we_do leftFont"
									onclick="location.href='#'">
									<div class="top_line"></div>
									<br>
									<h4 class="what_we_do_title">내 댓글 관리</h4>
									<div class="what_we_do_content">작성한 댓글을 관리합니다.</div>
									<a class="what_we_do_icon" href="#"> <i
										class="fa fa-angle-right" aria-hidden="true"></i>
									</a>
								</div>
							</div>
							<div class="row">
								<div class="single_what_we_do leftFont"
									onclick="location.href='#'">
									<div class="top_line"></div>
									<br>
									<h4 class="what_we_do_title">비밀번호 변경</h4>
									<div class="what_we_do_content">비밀번호를 변경합니다.</div>
									<a class="what_we_do_icon" href="#"> <i
										class="fa fa-angle-right" aria-hidden="true"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
					<c:if test="${loginUser.memberId ne 'admin' }">
						<button class="" id="lastbtn"
							onclick="location.href='qnaListView.kh?qnaNo=${qna.qnaNo}'">문의하기</button>
					</c:if>
				</div>
			</div>
			<!--/tab-pane-->
		</div>
		<!--/tab-content-->
	</div>
	<!--/col-9-->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>