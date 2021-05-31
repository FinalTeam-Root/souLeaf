<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물자랑</title>
<jsp:include page="../common/header.jsp"></jsp:include>
  <link rel="stylesheet" href="animate.min.css">
</head>
<body>
	
    	    <!-- END nav -->
	<!-- <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="home.kh">Home <i class="ion-ios-arrow-forward"></i></a></span> <span> <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">식물자랑</h1>
          </div>
        </div>
      </div>
    </section> -->
    
    
     <section class="ftco-section bg-light">
      <div class="container">
        <div class="row justify-content-center pb-5 mb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h2 class="animated slideInUp" >Best 자랑하기</h2>
          </div>
        </div>
  

   <!--  좋아요 개수가 많은 이미지 3개 상단에 띄우기  -->
   

 

   
   
   <!-- 제목/사진/작성자/조회수/좋아요 갯수 확인가능  -->
   
  
   
    
    <!--섹션  이미지 3x3 띄우기-->
     
     
         <section class="ftco-section bg-light">
      <div class="container">
        <div class="row d-flex">
        
        <c:forEach items="${bList }" var="boast" varStatus="status">
        
          <div class="col-md-4 d-flex ftco-animate">
            <div class="blog-entry align-self-stretch">
              <a href="boastDetail.kh" class="block-20 rounded" style="background-image: url('/resources/images/image_1.jpg');">
              </a>
              <div class="text p-4">
              	<div class="meta mb-2">
                  <div>조회수${boast.boastCount } 좋아요</div>
                  <div>작성자 </div>
                 <!--  <div><a href="#">작성자</a></div> -->
                 
                 
                  <div><a href="boastDetail.kh" class="meta-chat"><span class="fa fa-comment"></span>댓글 </a></div>
                </div>
                <h3 class="heading">
                <c:url var="boastDetail" value="boastDetail.kh">
                	<c:param name="boastNo" value="${boast.boastNo }"></c:param>
                </c:url>
                <a href="${boastDetail }">${boast.boastTitle }</a></h3>
              </div>
            </div>
          </div>
          </c:forEach>
        
        
       
        </div>
        
       <!--페이징처리  -->
        <div class="row mt-1">
          <div class="col text-center">
            <div class="block-27">
      
              <ul>
                <li><a href="#">&lt;</a></li>
                <li class="active"><span>1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
            
            
                <li><a href="#">&gt;</a></li>
              </ul>
            </div>
          </div>
          
        <!--  글쓰기버튼 -->
        <div align = "right">
        <button class="btn btn-outline-success" onclick="location.href='boastWrite.kh'">글쓰기</button>
        </div>
       
        </div>
      </div>
    </section>
          
  
        
      
	<br><br><br>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>