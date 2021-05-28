<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물도감</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/curiosity/curiosity-style.css">
<link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">

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
									<h2 class="heading-section p-1">${curiosity.curiosityContent }</h2>
									<div class="media p-2">
									  <img src="resources/images/main_bg_8.jpg" alt="John Doe" class="mr-3 rounded-circle" style="width:60px; height: 60px">
									  <div class="media-body">
									    <strong>${curiosity.memberNick }</strong><br>
									    <small>${curiosity.curiosityDate }</small>
									    <small align="right">조회수 ${curiosity.curiosityCount }</small>
									    <small style="float: right"><a href="curiosityModifyView.kh?curiosityNo=${curiosity.curiosityNo }&page=${page }&count=${count}">수정</a></small>
									    <a href="curiosityListView.kh?page=${page }&count=${count}">목록</a>
									  </div>
									</div>
										<hr>
											<div class="row">										
												<div class="col-md-12 contact-wrap w-100 p-md-5 p-4" style="min-height: 300px">
													${curiosity.curiosityContents }
												</div>
											</div>
										<hr>
										
									<p class="p-3" style="margin-bottom: 0px"><strong>댓글 <span id="comment-count">0</span>개</strong></p>
									<input type="hidden" id="curiosityNo" value="${curiosity.curiosityNo }">
									<span id="curiosity-comment"></span>
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
									<div class="row">
									<textarea class="form-control ml-4 mr-1 " id="replyContent" style="width: 90%" placeholder="댓글을 남겨주세요" ></textarea>
									<button class="mt-4 p-2 btn btn-secondary" style="float:right;" onclick="replyRegister(${curiosity.curiosityNo})">등록</button>
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
  <script src="resources/js/curiosity/curiosity-detail.js"></script>
</body>
</html>