<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물도감</title>
<jsp:include page="../common/header.jsp"></jsp:include>
</head>
<body>

  <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="home.kh">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">식물도감 <button class="btn btn-success btn-xs" onclick="location.href='plantWrite.kh'">도감 등록</button></h1>
          </div>
        </div>
      </div>
    </section>
    
   <section class="ftco-section bg-light">
			<div class="container">
				<div class="row" id="plant-list">
					<!-- <div class="col-md-6 col-lg-3 ftco-animate">
						<div class="staff">
							<div class="img-wrap d-flex align-items-stretch">
								<div class="img align-self-stretch" style="background-image: url(images/staff-1.jpg);"></div>
							</div>
							<div class="text pt-3 px-3 pb-4 text-center">
								<h3>Lloyd Wilson</h3>
								<span class="position mb-2">Health Coach</span>
								<div class="faded">
									<p>I am an ambitious workaholic, but apart from that, pretty simple person.</p>									
	             				 </div>
							</div>
						</div>
					</div> -->
				</div>
			</div>
		</section>

<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="resources/js/plant/plant-list.js"></script>
</body>
</html>