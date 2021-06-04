<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link href='resources/css/admin/admin-style.css' rel='stylesheet' />
</head>
<body>

    <section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
         <div class="col-lg-3 sidebar pl-lg-5 ftco-animate">
            <div class="sidebar-box">
              <form action="#" class="search-form">
                <div class="form-group">
                  <span class="fa fa-search"></span>
                  <input type="text" class="form-control" placeholder="Type a keyword and hit enter">
                </div>
              </form>
            </div>
            <div class="sidebar-box ftco-animate">
              <div class="categories">
                <h3>Services</h3>
                <li><a href="adminPlant.kh">도감 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="adminMember.kh">회원 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">게시글 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">Q&A 관리 <span class="fa fa-chevron-right"></span></a></li>
              </div>
            </div>

          </div>
          
          <div class="col-lg-9 ftco-animate">
          
    
          
           <section class="ftco-section bg-light ftco-intro " id="section-counter">
    	<div class="container">
    		<div class="row">
    		
          <div class="col-md-6 d-flex align-self-stretch mt-4 mb-5 px-6 ftco-animate admin-form" onclick="location.href='adminPlant.kh'">
            <div class="d-block services text-center">
              <div class="icon d-flex align-items-center justify-content-center">
            		<i class="fas fa-journal-whills admin-icon"></i>
              </div>
              <div class="media-body ">
                <h3 class="heading">도감 관리</h3>
                 <div class="block-18 text-center">
              <div class="text">
                <strong class="number" data-number="50"></strong> 건
              </div>
              <div class="text">
              	<span>식물 데이터</span>
              </div>
            </div>
           
              </div>
            </div>      
          </div>
          
          <div class="col-md-6 d-flex align-self-stretch mt-4 mb-5 px-6 ftco-animate admin-form" onclick="location.href='adminMember.kh'">
            <div class="d-block services text-center">
              <div class="icon d-flex align-items-center justify-content-center">
            		<i class="fas fa-address-card admin-icon"></i>
              </div>
              <div class="media-body ">
                <h3 class="heading">회원 관리</h3>
                 <div class="block-18 text-center">
              <div class="text">
                <strong class="number" data-number="100"></strong> 명
              </div>
              <div class="text">
              	<span>활동중</span>
              </div>
            </div>
           
              </div>
            </div>    
          </div>
          
          <div class="col-md-6 d-flex align-self-stretch mt-5 px-6 ftco-animate admin-form" onclick="location.href='#'">
            <div class="d-block services text-center">
              <div class="icon d-flex align-items-center justify-content-center">
            		<i class="fas fa-pen-square admin-icon"></i>
              </div>
               <div class="media-body ">
                <h3 class="heading">게시글 관리</h3>
                 <div class="block-18 text-center">
              <div class="text">
                <strong class="number" data-number="500"></strong> 개
              </div>
              <div class="text">
              	<span>등록 된 게시글</span>
              </div>
            </div>
           
              </div>
            </div>      
          </div>
          
            <div class="col-md-6 d-flex align-self-stretch mt-5 px-6 ftco-animate admin-form" onclick="location.href='#'">
            <div class="d-block services text-center">
              <div class="icon d-flex align-items-center justify-content-center">
            		<i class="fas fa-headset admin-icon"></i>
              </div>
               <div class="media-body ">
                <h3 class="heading">QnA 관리</h3>
                 <div class="block-18 text-center">
              <div class="text">
                <strong class="number" data-number="20"></strong> 개
              </div>
              <div class="text">
              	<span>답변 대기</span>
              </div>
            </div>
           
              </div>
            </div>      
          </div>
          
        </div>
    	</div>
    </section>

          </div> <!-- .col-md-9 -->
         

        </div>
      </div>
    </section> <!-- .section -->

<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>