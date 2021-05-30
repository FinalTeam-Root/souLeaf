<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>souLeaf - 성장일기</title>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include> 
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
    <link href='resources/css/diary/calendar.css' rel='stylesheet' />
    <link href='resources/css/diary/diaryMain.css' rel='stylesheet' />
</head>
<body>  
    <!-- 다이어리 주인의 memberNo -->
    <input type="hidden" name="memberDiary" id="memberDiary" value="${diary.memberNo }">
    <!-- 방명록을 작성하는 사람의 memberNo -->
    <input type="hidden" name="memberNo" id="memberNo" value="${loginUser.memberNo}">
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
			
				<div class="col-md-12 tab-pane active" id="myDiary-calendar">
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
									<h6 class="card-category text-gray" name="memberId">${diary.memberId }</h6>
									<h4 class="card-title" name="memberNick">${diary.memberNick }</h4>
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
					<div class="video">
						<div class="video-Companion">
							<select class="form-select" name="companionNo" id="selectVideo">

							</select>
						</div>
						<div class="video-play">
								<div class="play">비디오 영역</div>
						</div>
					</div>
					<!-- 사진 영역  -->
					<div class="picture-section">      
						<div id="carouselExampleControls" class="carousel slide" data-touch="false" data-interval="false">
							<div class="carousel-inner">

  					  		</div> <!-- carousel-inner -->
							<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev" >
								<span class="carousel-control-prev-icon changecolor" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
							</a>
							<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
								<span class="carousel-control-next-icon changecolor" aria-hidden="true"></span>
								<span class="sr-only">Next</span>
							</a>
						</div> <!-- carouselExampleControls -->    
					</div> <!-- picture -->
				</div> <!--  myDiary-picture -->
				
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
	
							</div>
						</div>
				</div>
			</div>
		</div>
    
	<!-- 일기 수정 삭제 모달창 -->
		<input type="hidden" name="diaryRepicture" value="0">
		<input type="hidden" id="diaryUniqNo" value="0">
       	<div class="modal fade" tabindex="-1" role="dialog" id="eventModal-modify">
           	<div class="modal-dialog" role="document">
               	<div class="modal-content">
                   	<div class="modal-header">
	                      <h5>일기 보기</h5>
	                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                      <span aria-hidden="true">&times;</span></button>
	                      <h4 class="modal-title"></h4>
	               	</div>
	               		<div class="modal-body">
		               		<div class="form-group">
								<div class="col-xs-12">
								<label class="col-xs-4" for="edit-selectPlant" >반려식물</label>
									<select class="form-control form-control-sm" name="companionNo" id="selectCompanion">

									</select>
								</div>
		                   	</div>
							<div class="form-group">
								<div class="col-xs-12">
									<label class="col-xs-4" for="edit-title">제목</label>
									<input class="form-control form-control-sm" type="text" name="diaryTitle" id="modify-edit-title" required="required" />
								</div>
		                   	</div>
							<div class="form-group">
								<label class="col-xs-4" for="edit-start">날짜선택</label>
								<div class="col-xs-12 input-group date" id="datapicker2">
									<input class="form-control datetimepicker-input" type="text" name="diaryStartDate" id="modify-edit-date" value="start"/>
									<div class="input-group-append" data-toggle="datetimepicker">
										<div class="input-group-text"><i class="fa fa-calendar"></i></div> 
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-xs-12">
									<label class="col-xs-4" for="edit-color">색상</label>
									<div class="row colorspace">
										<div class="custom-radios">
										  <div>
										    <input type="radio" id="color-11" name="color" value="#D25565">
										    <label for="color-11">
										      <span>
										      </span>
										    </label>
										  </div>
										  <div>
										    <input type="radio" id="color-22" name="color" value="#9775fa">
										    <label for="color-22">
										      <span>
										      </span>
										    </label>
										  </div>	
										  <div>
										    <input type="radio" id="color-33" name="color" value="#ffa94d">
										    <label for="color-33">
										      <span>
										      </span>
										    </label>
										  </div>
										  <div>
										    <input type="radio" id="color-44" name="color" value="#74c0fc">
										    <label for="color-44">
										      <span>
										      </span>
										    </label>
										  </div>
										  <div>
										    <input type="radio" id="color-55" name="color" value="#f06595">
										    <label for="color-55">
										      <span>
										      </span>
										    </label>
										  </div>
										  <div>
										    <input type="radio" id="color-66" name="color" value="#63e6be">
										    <label for="color-66">
										      <span>
										      </span>
										    </label>
										  </div>
										  <!-- <div>
										    <input type="radio" id="color-77" name="color" value="#4d638c">
										    <label for="color-77">
										      <span>
										      </span>
										    </label>
										  </div> -->
										</div>
									</div>
								</div>
		                   	</div>
							<div class="form-group">
								<div class="col-xs-12">
									<label class="col-xs-4" for="edit-desc">내용</label>
										<textarea rows="4" cols="50" class="form-control form-control-sm" onclick="diaryModify(this);" name="diaryContent" id="edit-desc2" ></textarea>
										<p id="wordCount4">(0/최대 200자 작성가능)<p>
								</div>
							</div>
							<br>
							<div class="form-group">
								<label class="col-xs-4" for="edit-lastWater">마지막 물 준 날</label>
								<div class="col-xs-12 input-group date" id="datapicker2">
									<input class="form-control datetimepicker-input" type="text" name="companionLastwater" id="modify-edit-lastWater"/>
									<div class="input-group-append" data-toggle="datetimepicker">
										<div class="input-group-text"><i class="fa fa-calendar"></i></div> 
									</div>
								</div>
		                   	</div>
	           			</div><!-- /.modal-body -->
	               </div><!-- /.modal-content -->
	           </div><!-- /.modal-dialog -->
	       </div><!-- /.modal -->
	   <!-- 모달창 끝 -->
	
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include> 
    <script src="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
    <script src="resources/js/diary/diaryMain.js"></script>   
    <script src='resources/js/diary/calendar.js'></script>
    <script src='resources/js/diary/ko.js'></script>
    <script src='resources/js/diary/locales-all.js'></script>
</body>
</html>
