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

<!--   <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="home.kh">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">식물도감</h1>
          </div>
        </div>
      </div>
    </section> -->
      <section class="ftco-section bg-light divup">
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
							<form action="plantRegister.kh" method="post" enctype="multipart/form-data">
							
							
							<div class="row no-gutters" id="pform1">
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<h3 class="mb-4">기본정보</h3>
										<div class="contactForm">
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label class="label" for="name">종류</label>
														<select class="form-control" name="plantKind" id="plantKind">
															<option value="1">1</option>
															<option value="2">2</option>
														</select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label class="label" for="name">특성</label>
														<select class="form-control" name="plantProperty" id="plantProperty">
															<option value="1">1</option>
															<option value="2">2</option>
														</select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label class="label" for="name">잎모양</label>
														<select class="form-control" name="plantLeaf" id="plantLeaf">
															<option value="1">1</option>
															<option value="2">2</option>
														</select>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="name">식물 이름(한글)</label>
														<input type="text" class="form-control" name="plantName" id="plantName">
													</div>
												</div>
												<div class="col-md-6"> 
													<div class="form-group">
														<label class="label" for="email">식물 이름(영어)</label>
														<input type="text" class="form-control" name="plantEngname" id="plantEngname">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">학명</label>
														<input type="text" class="form-control" name="plantPlantae" id="plantPlantae">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">물 주기</label>
														<input type="text" class="form-control" name="plantWater" id="plantWater">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">빛 정보</label>
														<input type="text" class="form-control" name="plantEnvi" id="plantEnvi">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">습도 정보</label>
														<input type="text" class="form-control" name="plantHumidity" id="plantHumidity">
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">식물 설명</label>
														<textarea name="plantDetail" class="form-control" id="plantDetail" cols="30" rows="4" placeholder="상세설명"></textarea>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<input type="button" value="다음 단계" class="btn btn-primary" onclick="fnMove(2)">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 1 -->
							
							<div class="row no-gutters" id="pform2">
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<h3 class="mb-4">상세정보</h3>
										<div class="contactForm">
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="name">빛 종류</label>
														<input type="text" class="form-control" name="piLightInfo" id="piLightInfo">
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">빛 내용</label>
														<textarea class="form-control" name="piLightContents"  id="piLightContents" cols="30" rows="4" ></textarea>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">온도 종류</label>
														<input type="text" class="form-control" name="piTempInfo" id="piTempInfo">
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">온도 내용</label>
														<textarea class="form-control" name="piTempContents"  id="piTempContents" cols="30" rows="4" ></textarea>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">습도 종류</label>
														<input type="text" class="form-control" name="piHumidityInfo" id="piHumidityInfo">
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">습도 내용</label>
														<textarea class="form-control" name="piHumidityContents"  id="piHumidityContents" cols="30" rows="4" ></textarea>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">물 종류</label>
														<input type="text" class="form-control" name="piWaterInfo" id="piWaterInfo">
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">물 내용</label>
														<textarea class="form-control" name="piWaterContents"  id="piWaterContents" cols="30" rows="4" ></textarea>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">흙 종류</label>
														<input type="text" class="form-control" name="piEarthInfo" id="piEarthInfo">
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">흙 내용</label>
														<textarea class="form-control" name="piEarthContents"  id="piEarthContents" cols="30" rows="4" ></textarea>
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">분갈이 시기</label>
														<textarea name="piBunting" class="form-control" id="piBunting" cols="30" rows="4" ></textarea>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
													<input type="button" value="이전 단계" class="btn btn-primary" onclick="fnMove(1)">
														<input type="button" value="다음 단계" class="btn btn-primary" onclick="fnMove(3)">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 2 -->
							
									<div class="row no-gutters" id="pform3">
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<h3 class="mb-4">이미지 등록</h3>
										<div class="contactForm">
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
	
<!-- <div id="fileUpload" class="dragAndDropDiv">Drag & Drop Files Here or Browse Files</div>
        <input type="file" name="fileUpload" id="fileUpload" style="display:none;" multiple/> -->
<center>
<span class="btn btn-light fileinput-button">
    <i class="glyphicon glyphicon-plus"></i>
    <span>Drag and Drop files...</span>
    <input type="file" name="ufile" id="ufile" multiple>
</span>
</center>    
        
<div id="output"><ul></ul></div>

													</div>
												</div>
												
													<div class="col-md-12">
													<div class="form-group">
													<input type="button" value="이전 단계" class="btn btn-primary" onclick="fnMove(2)">
														<input type="submit" value="등록" class="btn btn-primary">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 3 -->
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
    
   

<jsp:include page="../common/footer.jsp"></jsp:include>
  <script src="resources/js/plant/plant-main.js"></script>
</body>
</html>