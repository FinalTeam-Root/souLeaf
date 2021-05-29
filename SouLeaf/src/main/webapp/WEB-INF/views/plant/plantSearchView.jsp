<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			
			 <form action="plantSearch.kh" method="get" class="search-form">
                <div class="form-group">
                  <span class="fa fa-search"></span>
                  <input type="text" class="form-control" name="search" placeholder="식물 이름을 검색해 주세요." autocomplete="OFF">
                </div>
              </form><br>
              
				<div class="row" id="plant-list">
						<c:forEach items="${pList }" var="pi" varStatus="status">
					<div class="col-md-4 col-lg-3 ftco-animate">
						<div class="staff">
						<c:if test="${pList eq null }">
						검색결과가 없습니다
						</c:if>
						
							<div class="img-wrap d-flex align-items-stretch">
								<div class="img align-self-stretch" style="background-image: url(resources/uploadFiles/plant/${pi.plantFileRename});"></div>
							</div>
							<div class="text pt-3 px-3 pb-4 text-center">
								<span class="position mb-2">${pi.plantEngname }</span>
								<h3>${pi.plantName }</h3>
								<div class="faded">
	             				 </div>
							</div>
							
						</div>
					</div>
						</c:forEach>
					
				</div>
			</div>
		</section>

<jsp:include page="../common/footer.jsp"></jsp:include>
<!-- <script src="resources/js/plant/plant-list.js"></script> -->
</body>
</html>