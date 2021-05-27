<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Pet Sitting - Free Bootstrap 4 Template by Colorlib</title>
    <link rel="stylesheet" href="resources/css/member/member-style.css">
 	<jsp:include page="../common/header.jsp"></jsp:include> 
  </head>
  <body>
 

    <section class="ftco-section bg-light">
		
							<div class="row no-gutters">
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<h3 class="mb-4">Q&A</h3>
										<form action="qnaUpdate.kh" method="POST">
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">제목</label>
														<input type="text" class="form-control" value="${qna.qnaTitle }" name="qnaTitle"  id="name" placeholder="Name">
													</div>
												</div>
													<div class="form-group">
														<label class="label" for="#">내용</label>
														<textarea name="qnaContent" class="form-control" id="message" cols="30" rows="4" placeholder="내용을 입력해주세요">${qna.qnaContent }</textarea>
													</div>
												
												<div class="col-md-12">
												${qna.qnaNo }
												<input type="hidden" value="${qna.qnaNo }" name="qnaNo">
													<div class="form-group">
														<input type="submit" value="Send Message" class="btn btn-primary">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
								<div class="col-md-5 d-flex align-items-stretch">
									<div class="info-wrap w-100 p-5 img" style="background-image: url(images/img.jpg);">
				          </div>
								</div>
							</div>
			
		</section>


    <jsp:include page="../common/footer.jsp"></jsp:include> 
    <script src="resources/js/member/main.js"></script>
  </body>
</html>