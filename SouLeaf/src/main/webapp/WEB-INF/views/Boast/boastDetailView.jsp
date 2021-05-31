<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 자랑하기</title>
<jsp:include page="../common/header.jsp"></jsp:include>

<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">
</head>
<body>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center pb-5 mb-3">
				<div class="col-md-7 heading-section text-center ftco-animate">
					<h2 class="animated slideInUp">자랑하기 - 상세페이지</h2>
				</div>
			</div>


  <section class="ftco-section bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-md-12">
						<div class="wrapper">
					
							<div class="row no-gutters">
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
									<h2 class="heading-section p-1">${boast.boastTitle }</h2>
									<div class="media p-2">
									  <img src="resources/images/main_bg_8.jpg" alt="John Doe" class="mr-3 rounded-circle" style="width:60px; height: 60px">
									  <div class="media-body">
									  <div class="dropdown">
  <button class="btn btn-link dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    ${boast.memberName }
  </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="diaryMainOtherView.kh?memberDiary=${curiosity.memberNo }">일기 보러가기</a>
    <a class="dropdown-item" href="#">1:1 채팅</a>
  </div>
</div>

   
									    <small>${boast.boastDate }</small>
									    <small align="right">조회수 ${boast.boastCount }</small>
									    <small style="float: right"><a href="boastListView.kh?page=${page }&count=${count}">목록</a>&nbsp;&nbsp; <a href="boastUpdateView.kh?boastNo=${boast.boastNo }&page=${page }&count=${count}">수정</a></small>
									    
									  </div>
									</div>
										<hr>
											<div class="row">										
												<div class="col-md-12 contact-wrap w-100 p-md-5 p-4" style="min-height: 300px">
													${boast.boastContent }
												</div>
											</div>
										<hr>
										
									<p class="p-3" style="margin-bottom: 0px"><strong>댓글 <span id="comment-count">0</span>개</strong></p>
									<input type="hidden" id="boastNo" value="${boast.boastNo }">
									<span id="boast-comment"></span>


									<br>
									<div class="row">
									<textarea class="form-control ml-4 mr-1 " id="replyContent" style="width: 90%" placeholder="댓글을 남겨주세요" ></textarea>
									<button class="mt-4 p-2 btn btn-secondary" style="float:right;" onclick="replyRegister(${boast.boastNo})">등록</button>
									</div>
									
									</div>
								</div>
							
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	
	
	<!-- 댓글  -->


		<%-- 	<div class="pt-5 mt-5">
				<h3 class="mb-5">댓글</h3>
				<ul class="comment-list">
					<li class="comment">
						<div class="vcard bio">
							<img src="/resources/images/person_1.jpg" alt="Image placeholder">
						</div>
						<div class="comment-body">
							<h3>${boast.memberName }</h3>
							<div class="meta">작성일${boast.boastDate }</div>
							<p>댓글내용</p>
							<p>
								<a href="#" class="reply">등록</a>
							</p>
						</div>
					</li>


					<ul class="children">
						<li class="comment">
							<div class="vcard bio">
								<img src="/resources/images/person_1.jpg"
									alt="Image placeholder">
							</div>
							<div class="comment-body">
								<h3>${boast.memberName }</h3>
								<div class="meta">April 7, 2020 at 10:05pm</div>
								<p>나오나요?</p>
								<p>
									<a href="#" class="reply">Reply</a>
								</p>
							</div>


							<ul class="children">
								<li class="comment">
									<div class="vcard bio">
										<img src="/resources/images/person_1.jpg"
											alt="Image placeholder">
									</div>
									<div class="comment-body">
										<h3>${boast.memberName }</h3>
										<div class="meta">작성일${boast.boastDate }</div>
										<p>댓글내용 불러오기</p>
										<p>
											<a href="#" class="reply">등록<a href="#" class="reply">수정<a
													href="#" class="reply">삭제
										</p>
									</div>
			</div>

			<ul class="children">
				<li class="comment">
					<div class="vcard bio"></div>
					<div class="comment-body">

						<div class="meta">April 7, 2020 at 10:05pm</div>

					</div>
				</li>
			</ul>
			</li>
			</ul>
			</li>
			</ul>
			</li> END comment-list

 --%>


			<jsp:include page="../common/footer.jsp"></jsp:include>
			<script src="resources/js/summernote/summernote-lite.js"></script>
</body>
</html>