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
                <li><a href="adminPlant.kh" style=" color: #00bd56;">도감 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">회원 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">게시글 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">Q&A 관리 <span class="fa fa-chevron-right"></span></a></li>
              </div>
            </div>

          </div>
          
          <div class="col-lg-9 ftco-animate">
          
    
          
           <section class="mt-3" >
    	<div class="container">    	  
    	<div align="right" class="custom-search">
    	 <span class="fa fa-search"></span>
	    	<input id="custom-filter" class="plant-search" placeholder="" type="text"/>
    	</div>
        <form action="adminPlantDelete.kh" method="get">
    		 <table id="dataTable" class="row-border hover" style="width:100%">
        <thead>
            <tr>
                <th style="text-align: center"><input type="checkbox" id="check_all"></th>
                <th style="text-align: center">이미지</th>
                <th>식물명</th>
                <th>영문명</th>
                <th>등록일</th>
                <th>작업</th>
            </tr>
        </thead>
        <tbody>
                
          <c:forEach items="${pList }" var="pi" varStatus="status">
          
            <tr style="cursor: pointer;">
                <td align="center"><input type="checkbox" value="${pi.plantNo }" name="plant-check" class="checkbox_group"></td>
                <td align="center"><img src="resources/uploadFiles/plant/${pi.plantFileRename }" height="30px"></td>
                <td onclick="location.href='plantDetail.kh?plantNo=${pi.plantNo}'">${pi.plantName }</td>
                <td onclick="location.href='plantDetail.kh?plantNo=${pi.plantNo}'">${pi.plantEngname }</td>
                <td onclick="location.href='plantDetail.kh?plantNo=${pi.plantNo}'">${pi.plantDate }</td>
                <td><input type="button" class="btn btn-primary" value="수정" onclick="location.href='plantUpdateView.kh?plantNo=${pi.plantNo}'"></td>
            </tr>
          </c:forEach>
        </tbody>
        
    </table>
    <div class="custom-form" style="left:5%">
	    <input type="submit" class="btn btn-danger" value="삭제">
	    <input type="button" class="btn btn-success" value="등록" onclick="location.href='plantWrite.kh'">
    </div>
         <div class="custom-form" style="top:2%; left:5%; z-index:-1">식물데이터 ${pList.size()} 건</div>
        </form>      
         
    	</div>
    </section>

          </div> <!-- .col-md-9 -->
        

        </div>
      </div>
    </section> <!-- .section -->

<jsp:include page="../common/footer.jsp"></jsp:include>  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
<script src="resources/js/admin/admin-plant.js"></script>

</body>
</html>