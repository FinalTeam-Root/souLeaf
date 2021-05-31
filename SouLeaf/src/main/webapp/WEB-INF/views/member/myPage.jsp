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

.text-successes {
	color: #00bd56;
}

.cardform {
	position: relative;
	display: flex;
	flex-direction: column;
	min-width: 0;
	word-wrap: break-word;
	background-color: #fff;
	background-clip: border-box;
	border: 1px solid #e3e6f0;
	border-radius: 0.35rem;
	margin: 0px auto;
}

.cardform-header {
	padding: 0.75rem 1.25rem;
	margin-bottom: 0;
	background-color: #f8f9fc;
	border-bottom: 1px solid #e3e6f0;
}

.shadower {
	box-shadow: 0 0.15rem 1.75rem 0 rgba(58, 59, 69, 0.15) !important;
}

.display-flex {
	display: flex;
}

.align-center {
	align-items: center;
}

.form-control {
	height: calc(1.5em + 0.75rem + 2px);
	border-radius: 0.35rem;
}

.table-bordered th, .table-bordered td {
	border: 1px solid #e3e6f0;
}

.table thead th {
	vertical-align: middle;
}

#poststable {
	table-layout: fixed;
}
#poststable thead tr th{
	font-size:5px;
	text-align:center;
}

#poststable thead tr th:nth-child(1){
	width: 36px;
	table-layout: fixed;
}
#poststable thead tr th:nth-child(2){
	width: 61px;
	table-layout: fixed;
}
#poststable thead tr th:nth-child(3){
	width: 399px;
	table-layout: fixed;
	text-overflow: ellipsis;
}
#poststable thead tr th:nth-child(4){
	width: 108px;
	table-layout: fixed;
}
#poststable thead tr th:nth-child(5){
	width: 61px;
	table-layout: fixed;
}
#poststable tbody tr td:nth-child(2){
	width: 61px;
	text-align:center;
	table-layout: fixed;
}
#poststable tbody tr td:nth-child(3){
	width: 399px;
	table-layout: fixed;
	white-space: nowrap;
    overflow: hidden;
	text-overflow: ellipsis;
	height: 10px;
}
#poststable tbody tr td:nth-child(4){
	width: 108px;
	text-align:center;
	table-layout: fixed;
}
#poststable tbody tr td:nth-child(5){
	text-align:center;
	table-layout: fixed;
}
.btn-danger {
	font-size:5px;
	float: right;
    height: 29px;
    width: 58px;
    padding-top: 0px;
    padding-bottom: 0px;
}


</style>
</head>
<body>
	<div class="container bootstrap snippet">
		<br> <br>
		<div class="row">
			<div class="col-sm-10">
				<h4>User nick 님</h4>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<!--left col-->
				<div class="text-center">
					<img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
						class="avatar img-circle img-thumbnail" alt="avatar"
						style="width: 100%; height: 230px;"> <br> <input
						type="file" class="text-center center-block file-upload">
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
				<ul class="nav nav-tabs" id="myTab" role="tablist">
					<li class="nav-item" role="presentation"><a
						class="nav-link active" id="member-tab" data-toggle="tab"
						href="#member" role="tab" aria-controls="member"
						aria-selected="true">회원정보</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="posts-tab" data-toggle="tab" href="#posts" role="tab"
						aria-controls="posts" aria-selected="false">내 게시물</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="comments-tab" data-toggle="tab" href="#comments" role="tab"
						aria-controls="comments" aria-selected="false">내 댓글</a></li>
					<li class="nav-item" role="presentation"><a class="nav-link"
						id="question-tab" data-toggle="tab" href="#question" role="tab"
						aria-controls="question" aria-selected="false">QnA문의</a></li>
				</ul>
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
									<h4 class="what_we_do_title">비밀번호 변경</h4>
									<div class="what_we_do_content">비밀번호를 변경합니다.</div>
									<a class="what_we_do_icon" href="#"> <i
										class="fa fa-angle-right" aria-hidden="true"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
					<!-- 내 게시물 -->
					<div class="tab-pane fade" id="posts" role="tabpanel" aria-labelledby="posts-tab">
						<div class="container">
							<div class="cardform shadower mb-4"> <!-- 그림자 주기 -->
								<div class="cardform-header py-3"> <!-- 게시판 헤드 -->
									<div class="row">
										<div class="col align-self-start"></div>
										<div class="col align-self-center"></div>
										<div class="col align-self-center"></div>
										<div class="col align-self-end">
											<select class="custom-select custom-select-sm" id="browsers"name="browsers">
												<option value="boast">자랑하기</option>
												<option value="clinic">클리닉</option>
												<option value="curiosity">궁금해요</option>
											</select>
										</div>
									</div>
<!-- 									<div class="ml-auto display-flex align-center"> -->
<!-- 										<input type="text" name="" class="form-control" -->
<!-- 											placeholder="제목을 입력하세요"> -->
<!-- 										<button class="btn btn-md btn-primary ml-2">Search</button> -->
<!-- 									</div> -->
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table id="poststable" class="table table-bordered"
											width="100%" cellspacing="0">
											<thead>
												<tr>
													<th>체크</th>
													<th>글 번호</th>
													<th>제목</th>
													<th>등록일</th>
													<th>조회수</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>
														<div class="custom-control custom-checkbox">
															<input type="checkbox" class="custom-control-input"
																id="customCheck1"> <label
																class="custom-control-label" for="customCheck1"></label>
														</div>
													</td>
													<td>0001</td>
													<td>Edinburgh</td>
													<td>2011/04/25</td>
													<td>11</td>
												</tr>
												<tr>
													<td>
														<div class="custom-control custom-checkbox">
															<input type="checkbox" class="custom-control-input"
																id="customCheck1"> <label
																class="custom-control-label" for="customCheck1"></label>
														</div>
													</td>
													<td>0001</td>
													<td>EdinburghEdinburghEdinburghEdinburghEdinburghEdinburghEdinburghEdinburghEdinburghEdinburgh</td>
													<td>9999/88/88</td>
													<td>11</td>
												</tr>
											</tbody>
										</table>
										<div class="col buttnRight">
											<button type="button" class="btn btn-danger">삭제</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="tab-pane fade" id="comments" role="tabpanel"
						aria-labelledby="comments-tab">내 댓글</div>
					<div class="tab-pane fade" id="question" role="tabpanel"  aria-labelledby="question-tab">QnA문의
					<c:if test="${loginUser.memberId eq 'admin' }">
						<button class="" id="lastbtn" onclick="location.href='qnaListView.kh'">답변하기</button>
					</c:if>
					<c:if test="${loginUser.memberId ne 'admin' }">
						<button class="" id="lastbtn" onclick="location.href='qnaListView.kh?qnaNo=${qna.qnaNo}'">문의하기</button>
					</c:if>
					
					</div>
				</div>
				<!--/tab-pane-->
			</div>
			<!--/tab-content-->

		</div>
		<!--/col-9-->
	</div>
	<!--/row-->
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
</body>
</html>