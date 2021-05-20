<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물도감</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/plant/plant-style.css">
</head>
<body>

  <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="home.kh">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">식물도감</h1>
          </div>
        </div>
      </div>
    </section>
    
      <section class="ftco-section bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="heading-section">식물도감 등록</h2>
					</div>
				</div>
				
				<div class="row justify-content-center">
					<div class="col-md-12">
						<div class="wrapper">
							<div class="row mb-5">
								<div class="col-md-4">
									<div class="dbox w-100 text-center">
				        		<div class="picon d-flex align-items-center justify-content-center" id="step1">
				        			<span class="fas fa-seedling"></span>
				        		</div>
				        		<div class="text">
					            <p><span id="ptext1">기본정보 입력</span></p>
					          </div>
				          </div>
								</div>
								<div class="col-md-4">
									<div class="dbox w-100 text-center">
				        		<div class="picon d-flex align-items-center justify-content-center" id="step2">
				        			<span class="fab fa-pagelines"></span>
				        		</div>
				        		<div class="text">
					            <p><span id="ptext2">상세정보 입력</span></p>
					          </div>
				          </div>
								</div>
								<div class="col-md-4">
									<div class="dbox w-100 text-center">
				        		<div class="picon d-flex align-items-center justify-content-center" id="step3">
				        			<span class="far fa-images"></span>
				        		</div>
				        		<div class="text">
					            <p><span id="ptext3">이미지 등록</span></p>
					          </div>
				          </div>
								</div>
							
							</div>
							<div class="row no-gutters">
								<div class="col-md-7">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<h3 class="mb-4">Contact Us</h3>
										<form method="POST" id="contactForm" name="contactForm" class="contactForm">
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="name">Full Name</label>
														<input type="text" class="form-control" name="name" id="name" placeholder="Name">
													</div>
												</div>
												<div class="col-md-6"> 
													<div class="form-group">
														<label class="label" for="email">Email Address</label>
														<input type="email" class="form-control" name="email" id="email" placeholder="Email">
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">Subject</label>
														<input type="text" class="form-control" name="subject" id="subject" placeholder="Subject">
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">Message</label>
														<textarea name="message" class="form-control" id="message" cols="30" rows="4" placeholder="Message"></textarea>
													</div>
												</div>
												<div class="col-md-12">
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
									<div class="info-wrap w-100 p-5 img" style="background-image: url(resources/images/img.jpg);">
				          </div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
    
   

<jsp:include page="../common/footer.jsp"></jsp:include>
  <script src="resources/js/plant/plant-main.js"></script>
</body>
</html>