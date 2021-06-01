<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
  <jsp:include page="common/header.jsp"></jsp:include>
  <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
  <link rel="stylesheet" href="resources/css/home/home-style.css">
    <div class="hero-wrap js-fullheight" style="background-image: url('resources/images/main_bg_5.jpg');" data-stellar-background-ratio="0.5">
     <video class="video-intro" id="myVideo" poster="https://mdbootstrap.com/img/Photos/Others/background.jpg" playsinline autoplay muted loop>
      <source src="/resources/video/video-pc.mp4" type="video/mp4">
    </video>
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-11 ftco-animate text-center">
          	<h1 class="mb-4" style="font-size: 100px">누구나 식물을<br> 쉽게, 즐겁게, 함께</h1>
            <!-- <p><a href="#" class="btn btn-primary mr-md-4 py-3 px-4" id="more">Learn more <span class="ion-ios-arrow-forward"></span></a></p> -->
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section bg-light ftco-no-pt ftco-intro">
    	<div class="container">
    		<div class="row">
          <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
            <div class="d-block services active text-center">
              <div class="icon d-flex align-items-center justify-content-center">
            		<!-- <i class="ri-medal-fill" style="font-size:40px; color:#FFD700;"></i> -->
            		<i class="fas fa-crown" style="font-size:40px; color:#FFD700;"></i>
              </div>
               <div class="media-body">
                <h3 class="heading" style="text-align: left">BEST 1</h3>
                <div class="rank-form">
                  <img src="resources/uploadFiles/plant/120210531162553.jpg" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0">
                  <div class="text pt-3 px-3 pb-4 text-center">
					<span class="position mb-2">Red box Gum</span>
					<h3>유칼립투스 폴리안</h3>
				</div>
				</div>
              </div>
            </div>      
          </div>
          
          <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
            <div class="d-block services text-center">
              <div class="icon d-flex align-items-center justify-content-center">
            		<!-- <i class="ri-medal-fill" style="font-size:40px; color:#C0C0C0;"></i> -->
            		<i class="fas fa-crown" style="font-size:40px; color:#C0C0C0;"></i>
              </div>
               <div class="media-body">
                <h3 class="heading" style="text-align: left">BEST 2</h3>
                <div class="rank-form">
                  <img src="/resources/uploadFiles/plant/120210531142943.jpg" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0">
                  <div class="text pt-3 px-3 pb-4 text-center">
					<span class="position mb-2">Red box Gum</span>
					<h3>유칼립투스 폴리안</h3>
				</div>
				</div>
              </div>
            </div>    
          </div>
          
          <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
            <div class="d-block services text-center">
              <div class="icon d-flex align-items-center justify-content-center">
            		<!-- <i class="ri-medal-fill" style="font-size:40px; color:#865d5a;"></i> -->
            		<i class="fas fa-crown" style="font-size:40px; color:#865d5a;"></i>
              </div>
              <div class="media-body">
                <h3 class="heading" style="text-align: left">BEST 3</h3>
                <div class="rank-form">
                  <img src="/resources/uploadFiles/plant/120210531162046.jpg" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0">
                  <div class="text pt-3 px-3 pb-4 text-center">
					<span class="position mb-2">Red box Gum</span>
					<h3>유칼립투스 폴리안</h3>
				</div>
				</div>
              </div>
            </div>      
          </div>
          
        </div>
    	</div>
    </section>
<div class="typing-txt"> 
  <ul>
    <li>개나리</li>
    <li>민달레</li>
    <li>스투키</li>
</ul>

</div> 

  
    <section class="ftco-section ftco-no-pt ftco-no-pb" style="background: #fff">
    	<div class="container">
    		<div class="row d-flex no-gutters">
    			
    			<div class="col-md-12 pl-md-5 py-md-5">
    				<div class="heading-section pt-md-5">
	            <h3 class="mb-4" style="color:#00b564; font-weight: 800">Plant Search</h3>
    				</div>
    				<div class="row" align="center" >
	    				<div class="col-md-12 services-2 w-100 d-flex" >
	    					<div class="text pl-3">
	    						
			  <form action="plantSearch.kh" method="get" class="search-form">
                <div class="form-group" >
                 <h1 style="display: -webkit-inline-box; font-weight: 800; font-size: 100px; /* color: #fff */">나는&nbsp;<input type="text" class="form-control plant-search" name="search" id="plantSearch" autocomplete="OFF" maxlength="11">&nbsp;<p class="typing"></p>를</h1>
                </div>
              </form>
	    						<h1 style="font-weight: 800; font-size: 100px; /* color: #fff */">잘 키우는 방법이</h1>
	    						<h1 style="font-weight: 800; font-size: 100px; /* color: #fff */">궁금하다.</h1>
	    					</div>
	    				</div>
	    				
	    				
	    			</div>
	        </div>
        </div>
    	</div>
    </section>


    <section class="ftco-section bg-light ftco-faqs">
    	<div class="container">
    		<div class="row">
    			

    			<div class="col-lg-12" align="center">
    				<div class="heading-section mb-5 mt-5 mt-lg-0">
	            <h1 class="mb-3" style="font-size:     font-size: 3.21429vw"><strong>어떤 종류의 식물을 찾고있나요?</strong></h1>
    				</div>
    				<div>
    				<div class="form-group contactForm" id="kind-form">
	
	<div class="btn-group btn-group-toggle" data-toggle="buttons" >	
		<label class="btn btn-outline-success" for="plant-kind1"  style="border-radius: 50px">
			<input type="radio" name="plant-kind" id="plant-kind1" value="1"> 잎이 있는 식물
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success" for="plant-kind2"  style="border-radius: 50px" >
			<input type="radio" name="plant-kind" id="plant-kind2" value="2" > 공중식물
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success" for="plant-kind3"  style="border-radius: 50px">
			<input type="radio" name="plant-kind" id="plant-kind3" value="3" > 다육식물
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success" for="plant-kind4"  style="border-radius: 50px">
			<input type="radio" name="plant-kind" id="plant-kind4" value="4" > 덩굴식물
		</label>
	</div>
</div>
    				</div>
	        </div>
        </div>
    	</div>
    </section>

    <section class="ftco-section testimony-section" style="background-image: url('resources/images/main_bg_4.jpg');">
    	<div class="overlay"></div>
      <div class="container">
        <div class="row justify-content-center pb-5 mb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h2>Happy Clients &amp; Feedbacks</h2>
          </div>
        </div>
        <div class="row ftco-animate">
          <div class="col-md-12">
            <div class="carousel-testimony owl-carousel ftco-owl">
              <div class="item">
                <div class="testimony-wrap py-4">
                	<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-quote-left"></span></div>
                  <div class="text">
                    <p class="mb-4">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(resources/images/person_1.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">Roger Scott</p>
		                    <span class="position">Marketing Manager</span>
		                  </div>
	                  </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap py-4">
                	<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-quote-left"></span></div>
                  <div class="text">
                    <p class="mb-4">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(resources/images/person_2.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">Roger Scott</p>
		                    <span class="position">Marketing Manager</span>
		                  </div>
	                  </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap py-4">
                	<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-quote-left"></span></div>
                  <div class="text">
                    <p class="mb-4">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(resources/images/person_3.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">Roger Scott</p>
		                    <span class="position">Marketing Manager</span>
		                  </div>
	                  </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap py-4">
                	<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-quote-left"></span></div>
                  <div class="text">
                    <p class="mb-4">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(resources/images/person_1.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">Roger Scott</p>
		                    <span class="position">Marketing Manager</span>
		                  </div>
	                  </div>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap py-4">
                	<div class="icon d-flex align-items-center justify-content-center"><span class="fa fa-quote-left"></span></div>
                  <div class="text">
                    <p class="mb-4">Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                    <div class="d-flex align-items-center">
                    	<div class="user-img" style="background-image: url(resources/images/person_2.jpg)"></div>
                    	<div class="pl-3">
		                    <p class="name">Roger Scott</p>
		                    <span class="position">Marketing Manager</span>
		                  </div>
	                  </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>



    <section class="ftco-section bg-light">
      <div class="container">
        <div class="row justify-content-center pb-5 mb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h2>Latest news from our blog</h2>
          </div>
        </div>
        <div class="row d-flex">
          <div class="col-md-4 d-flex ftco-animate">
            <div class="blog-entry align-self-stretch">
              <a href="blog-single.html" class="block-20 rounded" style="background-image: url('resources/images/image_1.jpg');">
              </a>
              <div class="text p-4">
              	<div class="meta mb-2">
                  <div><a href="#">April 07, 2020</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                </div>
                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a></h3>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
            <div class="blog-entry align-self-stretch">
              <a href="blog-single.html" class="block-20 rounded" style="background-image: url('resources/images/image_2.jpg');">
              </a>
              <div class="text p-4">
              	<div class="meta mb-2">
                  <div><a href="#">April 07, 2020</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                </div>
                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a></h3>
              </div>
            </div>
          </div>
          <div class="col-md-4 d-flex ftco-animate">
            <div class="blog-entry align-self-stretch">
              <a href="blog-single.html" class="block-20 rounded" style="background-image: url('resources/images/image_3.jpg');">
              </a>
              <div class="text p-4">
              	<div class="meta mb-2">
                  <div><a href="#">April 07, 2020</a></div>
                  <div><a href="#">Admin</a></div>
                  <div><a href="#" class="meta-chat"><span class="fa fa-comment"></span> 3</a></div>
                </div>
                <h3 class="heading"><a href="#">Even the all-powerful Pointing has no control about the blind texts</a></h3>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb img" style="background-image: url(resources/images/main_bg_3.jpg);">
			<div class="overlay"></div>
    	<div class="container">
    		<div class="row d-md-flex justify-content-end">
    			<div class="col-md-12 col-lg-6 half p-3 py-5 pl-lg-5 ftco-animate">
    				<h2 class="mb-4">Free Consultation</h2>
    				<form action="#" class="appointment">
    					<div class="row">
    						<div class="col-md-12">
									<div class="form-group">
			    					<div class="form-field">
	          					<div class="select-wrap">
	                      <div class="icon"><span class="fa fa-chevron-down"></span></div>
	                      <select name="" id="" class="form-control">
	                      	<option value="">Select services</option>
	                        <option value="">Cat Sitting</option>
	                        <option value="">Dog Walk</option>
	                        <option value="">Pet Spa</option>
	                        <option value="">Pet Grooming</option>
	                        <option value="">Pet Daycare</option>
	                      </select>
	                    </div>
			              </div>
			    				</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
			              <input type="text" class="form-control" placeholder="Your Name">
			            </div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
			              <input type="text" class="form-control" placeholder="Vehicle number">
			            </div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
			    					<div class="input-wrap">
			            		<div class="icon"><span class="fa fa-calendar"></span></div>
			            		<input type="text" class="form-control appointment_date" placeholder="Date">
		            		</div>
			    				</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
			    					<div class="input-wrap">
			            		<div class="icon"><span class="fa fa-clock-o"></span></div>
			            		<input type="text" class="form-control appointment_time" placeholder="Time">
		            		</div>
			    				</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
			              <textarea name="" id="" cols="30" rows="7" class="form-control" placeholder="Message"></textarea>
			            </div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
			              <input type="submit" value="Send message" class="btn btn-primary py-3 px-4">
			            </div>
								</div>
    					</div>
	          </form>
    			</div>
    		</div>
    	</div>
    </section>

  <jsp:include page="common/footer.jsp"></jsp:include> 
  </body>
</html>