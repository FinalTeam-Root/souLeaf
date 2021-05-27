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
									<h2 class="heading-section">${curiosity.curiosityContent }</h2>
									<div class="media p-1">
									  <img src="resources/images/main_bg_8.jpg" alt="John Doe" class="mr-3 rounded-circle" style="width:60px; height: 60px">
									  <div class="media-body">
									    <strong>작성자</strong><br>
									    <small>2020-05-27</small>
									    <small align="right">조회수 0</small>
									  </div>
									</div>
										<hr>
											<div class="row">										
												<div class="col-md-12 contact-wrap w-100 p-md-5 p-4" style="min-height: 300px">
													${curiosity.curiosityContents }
												</div>
											</div>
										<hr>
										
									댓글 1개
									<br><br>

<div class="media p-3">
  <img src="resources/images/gallery-3.jpg" alt="John Doe" class="mr-3 rounded-circle" style="width:60px; height: 60px">
  <div class="media-body">
    <strong>댓글작성자 <small>2020-05-27 11:12:12</small></strong>
    <p class="p-1">댓글남겨요...</p>
  </div>
</div>

									<br><br>
									<textarea class="form-control"></textarea>

			
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