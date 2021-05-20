<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>souLeaf - 성장일기</title>
    <link rel="icon" type="image/png" sizes="16x16"  href="resources/images/favicon-16x16.png">
    <meta name="msapplication-TileColor" content="#ffffff">
	<meta name="theme-color" content="#ffffff">
    <link href='resources/css/diary/calendar.css' rel='stylesheet' />
    <link href='resources/css/diary/diaryMain.css' rel='stylesheet' />
    
    <script src='resources/js/diary/calendar.js'></script>
    <script src='resources/js/diary/ko.js'></script>
    <script src="resources/js/diary/diaryMain.js"></script>
    
</head>
<body>  
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include> 
    <%-- <input type="hidden" value="${guestbook.memberDiary }"> --%>
	<input type="hidden" name="memberDiary" value="2">
		<div class="diary-content">
			<div class="tab-content tab-space">
				<div class="nav-tab-content">
					<ul class="nav nav-pills" role="tablist">
						<!--
							color-classes: "nav-pills-primary", "nav-pills-info", "nav-pills-success", "nav-pills-warning","nav-pills-danger"
						-->
						<li class="nav-item">
							<a class="nav-link active" href="#myDiary-calendar" role="tab" data-toggle="tab">
								성장일기
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link " href="#myDiary-picture" role="tab" data-toggle="tab">
								사진첩
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#myDaiary-guest" role="tab" data-toggle="tab">
								방명록
							</a>
						</li>
					</ul>
				</div>
			
				<div class="tab-pane active" id="myDiary-calendar">
					<!-- 성장일기 메인에서 내 정보보기 -->
					<div class="myInfo">
						<div class="col-md-4">
							<div class="card card-profile">
								<div class="card-avatar">
									<a href="#">
										<img src="https://img.icons8.com/plasticine/100/000000/plant-under-sun.png"/>
									</a>
								</div>
								<div class="card-body ">
									<h6 class="card-category text-gray" name="memberId">${member.memberId }</h6>
									<h4 class="card-title" name="memberNick">${member.memberNick }</h4>
									<hr>
									<span>소개글 </span>
									<p class="card-description" name="memberIntro">
										안녕하세요~! 저는 식물을 사랑하는 사람입니다.
									</p>
									<span>반려식물</span>
									<p class="card-description">
										#산세베리아 / #무궁화 / #개나리
									</p>
									<a href="#" class="btn btn-primary">chat</a>
								</div>
							</div>
						</div>
					</div> <!-- myInfo -->
					
						<div class="calendar">
							<div id='calendar'></div>
						</div> <!-- calendar -->
				
				</div>
				
				<div class="tab-pane" id="myDiary-picture">
					<div class="">
						사진첩
					</div>
				</div>
				<div class="tab-pane" id="myDaiary-guest">
					<div class="comment">
						<div class="comment-content">
							<textarea id="comment-content" rows="3"></textarea>
						</div>
						<div class="comment-enroll">
							<span id="wordCount1">(0/최대 200자 작성가능)</span>
							<button type="button" id="btnGuestbook" class="btn btn-default btn-secondary">등록</button>
						</div>
						<div class="comment-list">
							<div class="card-body">
								<div class="row">
									<div class="col-md-2">
										<img src="https://img.icons8.com/pastel-glyph/64/000000/person-male--v3.png" class="img rounded-circle img-fluid user-img" style="width: 70px;"/>
										<a href="otherDiaryMain.kh?memberNo=${member.memberNo }"><p class="text-secondary text-center">김윤정</p></a>
									</div>
									<div class="col-md-10">
									   <div class="clearfix">
											<p>Using color to add meaning only provides a visual indication, which will not be conveyed to users of assistive technologies – such as screen readers. Ensure that information denoted by the color is either obvious from the content itself (e.g. the visible text), or is included through alternative means, such as</p>
											<p>
											<span class="datetime">2021.05.11 13:51</span> 
											<a href="#">수정  </a> <a href="#"> 삭제</a>
											</p>
										</div>
									</div>
								</div>
							</div>
							<div class="modify-section">
								<div class="modifyform">
									<div class="comment-retext">
										<textarea id="comment-modify" rows="3"></textarea>
									</div>
									<div class="comment-reEnroll">
										<span id="wordCount2">(0/최대 200자 작성가능)</span>
										<button type="button" class="btn btn-default btn-secondary">수정</button>
									</div>
								</div>
							</div>
							<div class="card-body">
								<div class="row">
									<div class="col-md-2">
										<img src="https://img.icons8.com/emoji/96/000000/person-facepalming.png" class="img rounded-circle img-fluid user-img" style="width: 70px;"/>
										<p class="text-secondary text-center">김윤정</p>
									</div>
									<div class="col-md-10">
									   <div class="clearfix">
											<p>잘보고 가요~ 너무 이뻐요 </p>
											<p>
											<span class="datetime">2021.05.11 13:51</span> 
											<a href="#">수정  </a> <a href="#"> 삭제</a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include> 
        
    <script>
      
    </script>
</body>
</html>
