<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">
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
                <li><a href="adminPlant.kh" >도감 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="adminMember.kh">회원 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="adminBoard.kh" style=" color: #00bd56;">게시글 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">Q&A 관리 <span class="fa fa-chevron-right"></span></a></li>
              </div>
            </div>

          </div> <!-- .col-md-3 -->
          
          <div class="col-lg-9 ftco-animate">
          
    
    <div class="tab-content tab-space">
			<div class="nav-tab-content">
				<ul class="nav nav-pills" role="tablist">
					<!--
						color-classes: "nav-pills-primary", "nav-pills-info", "nav-pills-success", "nav-pills-warning","nav-pills-danger"
					-->
					<li class="nav-item"><a class="nav-link active"
						href="#admin-boast" role="tab" data-toggle="tab"> 식물자랑 </a></li>
					<li class="nav-item"><a class="nav-link "
						href="#admin-clinic" role="tab" data-toggle="tab"> 식물클리닉 </a></li>
					<li class="nav-item"><a class="nav-link"
						href="#admin-curiosity" role="tab" data-toggle="tab"> 궁금해요 </a></li>
				</ul>
			</div>

			<div class="tab-pane active" id="admin-boast">
				    <section class="mt-3" style="position: relative;">
				    	<div class="container">    	  
				    	<div align="right" class="custom-search">
				    	 <span class="fa fa-search"></span>
					    	<input id="custom-filter" class="plant-search" placeholder="" type="text"/>
				    	</div>
				    		 <table id="dataTable1" class="row-border hover" style="width:100%">
				        <thead>
				            <tr>
				                <th style="text-align: center"><input type="checkbox" id="check_all"></th>
				                <th style="text-align: center">이미지</th>
				                <th>제목</th>
				                <th>작성자</th>
				                <th>등록일</th>
				            </tr>
				        </thead>
				        <tbody>
				                
				         
				    </table>
					    <div class="custom-btn-form">
						    <input type="submit" class="btn btn-danger" value="삭제">
					    </div>
				         <div class="custom-form">자랑하기데이터 건</div>
				         
				    	</div>
				    </section>
			</div>

			<div class="tab-pane" id="admin-clinic">
				식물클리닉
			</div>

			<div class="tab-pane" id="admin-curiosity">
				궁금ㅎ요
			</div>
			
			
		</div>
          
       

          </div> <!-- .col-md-9 -->
        

        </div>
      </div>
    </section> <!-- .section -->

<jsp:include page="../common/footer.jsp"></jsp:include>  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
<script src="resources/js/admin/admin-board.js"></script>

</body>
</html>