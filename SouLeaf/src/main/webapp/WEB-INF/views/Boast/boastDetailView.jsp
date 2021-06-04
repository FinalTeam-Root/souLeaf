<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물자랑</title>
<jsp:include page="../common/header.jsp"></jsp:include>

<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">
<link rel="stylesheet" href="resources/css/curiosity/curiosity-style.css">
</head>
<body>

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
									<h2 class="heading-section p-1 ml-3">${boast.boastTitle }</h2>
									<div class="media p-1 ml-3">
										<img src="resources/images/main_bg_8.jpg" alt="John Doe"
											class="mr-1 rounded-circle" style="width: 60px; height: 60px">
											
										<div class="media-body row">
											<div class="dropdown mt-2 col-md-6">
												<button class="btn dropdown-toggle" type="button"
													id="dropdownMenuButton" data-toggle="dropdown"
													aria-haspopup="true" aria-expanded="false"
													style="padding: 12px 10px; font-size: 15px; text-transform: none;">
													${boast.memberName }</button>
												<div class="dropdown-menu"
													aria-labelledby="dropdownMenuButton">
													<a class="dropdown-item"
														href="diaryMainOtherView.kh?memberDiary=${boast.memberNo }">일기
														보러가기</a> <a class="dropdown-item" href="#">1:1 채팅</a>
												</div>
												${boast.boastDate } &nbsp;&nbsp;<span
													class="far fa-eye"></span> ${boast.boastCount }
												&nbsp;&nbsp;<span class="fa fa-comment"></span> <span
													id="replyCount">0</span>


												<c:choose>
													<c:when test="${likecheck eq '0' or empty likecheck}">
														<!-- likecheck가0이면 빈하트-->
														<img src="/resources/images/ico_like_before.png"
															id="btn_like" align="left"
															style="cursor: pointer; width: 20px;">
													</c:when>
													<c:otherwise>
														<!-- likecheck가1이면 빨간 하트-->
														<img src="/resources/images/ico_like_after.png"
															id="btn_like" align="left"
															style="cursor: pointer; width: 20px;">
													</c:otherwise>
												</c:choose>
												<dd id="likecnt" style="margin-left: 5px;">${likecnt}</dd>



											</div>

 
 
											
											<span style="float: right" class="mt-4"><a
												href="boastListView.kh?page=${page }&count=${count}">목록</a>&nbsp;&nbsp;
												<c:if test="${loginUser.memberNo eq boast.memberNo  }">
													<a
														href="boastUpdateView.kh?boastNo=${boast.boastNo }&page=${page }&count=${count}">수정</a>&nbsp;&nbsp;
									    <a href="#">삭제</a>
												</c:if> </span>


											<div class="col-md-6">
											

											</div>
										</div>
										
									</div>
									<hr>
											<div class="row">										
												<div class="col-md-12 contact-wrap w-100 p-md-5 p-3" style="min-height: 300px">
													${boast.boastContent }
												</div>
											</div>
										<hr>
										<input type="hidden" id="loginNo" value="${loginUser.memberNo }">
									<p class="p-3" style="margin-bottom: 0px"><strong>댓글 <span id="comment-count">0</span>개</strong></p>
									<input type="hidden" id="boastNo" value="${boast.boastNo }">
									<span id="boast-comment"></span>
<!-- <div class="media p-3">
  <div>
  </div>
  <img src="resources/images/gallery-3.jpg" alt="John Doe" class="mr-3 mx-3 mt-2 rounded-circle" style="width:60px; height: 60px">
  <div class="media-body">
   <strong>댓글작성자</strong><br>
   <span>댓글남겨요...</span><br>
   <small>2020-05-27 11:12:12 <a href="" class="text-success">수정</a> <a href="" class="text-danger">삭제</a></small>
  </div>
</div> -->
									<br>
									<div class="row" style="position: relative;">
									<input type="text" class="form-control" id="replyContent" style="width: 95%; margin-left:1.5%; height: 32px !important;" placeholder="댓글을 남겨주세요" >
									<button class="mt-4 p-2 btn btn-secondary reply-btn" onclick="replyRegister(${boast.boastNo})">등록</button>
									</div>
									</div>
								</div>
							
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
          

<jsp:include page="../common/footer.jsp"></jsp:include>
  <script src="resources/js/summernote/summernote-lite.js"></script>
   <script src="resources/js/boast/boast-detail.js"></script>
  
</body>
</html>