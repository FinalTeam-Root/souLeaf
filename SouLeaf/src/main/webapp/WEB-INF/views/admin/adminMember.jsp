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
                <li><a href="adminMember.kh" style=" color: #00bd56;">회원 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">게시글 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="#">Q&A 관리 <span class="fa fa-chevron-right"></span></a></li>
              </div>
            </div>

          </div>
          
          <div class="col-lg-9 ftco-animate">
          
    
          
           <section class="mt-3" style="position: relative;" >
    	<div class="container">    	  
    	<div align="right" class="custom-search">
    	 <span class="fa fa-search"></span>
	    	<input id="custom-filter" class="plant-search" placeholder="" type="text"/>
    	</div>
        <form action="adminMemberDelete.kh" method="get">
    		 <table id="dataTable" class="row-border hover" style="width:100%">
        <thead>
            <tr>
                <th style="text-align: center"><input type="checkbox" id="check_all"></th>
                <th style="text-align: center">이미지</th>
                <th>아이디</th>
                <th>닉네임</th>
                <th>이름</th>
                <th>이메일</th>
                <th>가입일</th>
            </tr>
        </thead>
        <tbody>
                
          <c:forEach items="${mList }" var="mi" varStatus="status">
          <c:if test="${mi.memberStatus eq 'Y' }">
            <tr style="cursor: pointer;">
                <td align="center"><input type="checkbox" value="${mi.memberNo }" name="member-check" class="checkbox_group"></td>
                <c:if test="${mi.memberFileRename eq null }">
                <td align="center"><img src="resources/images/basicMemberImg.png" height="30px"></td>                
                </c:if>
                <c:if test="${mi.memberFileRename ne null }">
                <td align="center"><img src="resources/uploadFiles/member/${mi.memberFileRename }" class="member-img"></td>                
                </c:if>
                <td>${mi.memberId }</td>
                <td>${mi.memberNick }</td>
                <td>${mi.memberName }</td>
                <td>${mi.memberMail }</td>
                <td>${mi.memberJoin }</td>
            </tr>
          </c:if>
          <c:if test="${mi.memberStatus eq 'N' }">
            <tr style="cursor: pointer; background: #ff4b4b17">
                <td align="center"><button value="${mi.memberNo }" name="member-reset" class="btn" style="padding: o opx; color:#00bd56">활성화</button></td>
                <c:if test="${mi.memberFileRename eq null }">
                <td align="center"><img src="resources/images/basicMemberImg.png" height="30px"></td>                
                </c:if>
                <c:if test="${mi.memberFileRename ne null }">
                <td align="center"><img src="resources/uploadFiles/member/${mi.memberFileRename }" class="member-img"></td>                
                </c:if>
                <td>${mi.memberId }</td>
                <td>${mi.memberNick }</td>
                <td>${mi.memberName }</td>
                <td>${mi.memberMail }</td>
                <td>${mi.memberJoin }</td>
            </tr>
          </c:if>
          </c:forEach>
        </tbody>
        
    </table>
    <div class="custom-btn-form">
	    <input type="submit" class="btn btn-danger" value="비활성화">	    
    </div>
         <div class="custom-form">총회원 수 ${mList.size()} 활성 ${mStatus.statusY} 비활성${mStatus.statusN}</div> 
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
<script src="resources/js/admin/admin-member.js"></script>

</body>
</html>