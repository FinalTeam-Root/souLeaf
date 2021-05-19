<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>성장일기</title>
    <link href='resources/css/diary/calendar.css' rel='stylesheet' />
    <link href='resources/css/diary/diaryMain.css' rel='stylesheet' />
    
    <script src='resources/js/diary/calendar.js'></script>
    <script src='resources/js/diary/ko.js'></script>
    <script src="resources/js/diary/diaryMain.js"></script>
    
</head>
<body>  
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include> 
		<div clas="diary-content">
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
									<h6 class="card-category text-gray" name="memberId">아이디</h6>
									<h4 class="card-title" name="memberNick">닉네임</h4>
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
							<span>(0자/최대200자까지 작성)</span>
							<button type="button" class="btn btn-default btn-secondary">등록</button>
						</div>
						<div class="comment-list">
							<div class="card-body">
								<div class="row">
									<div class="col-md-2">
										<img src="https://img.icons8.com/emoji/96/000000/person-facepalming.png" class="img rounded-circle img-fluid user-img" style="width: 70px;"/>
										<p class="text-secondary text-center">김윤정</p>
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
										<span>(0자/최대200자까지 작성)</span>
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
							<div class="modify-section">
								<div class="modifyform">
									<div class="comment-retext">
										<textarea id="comment-modify" rows="3"></textarea>
									</div>
									<div class="comment-reEnroll">
										<span>(0자/최대200자까지 작성)</span>
										<button type="button" class="btn btn-default btn-secondary">수정</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

    <!-- 일기 등록, 수정 모달창 -->
    <form action="diaryRegister.kh" method="post" enctype="multipart/form-data">
        <div class="modal fade" tabindex="-1" role="dialog" id="eventModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5>일기 등록</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title"></h4>
                	</div>
                	<div class="modal-body">
                		<div class="form-group">
							<div class="col-xs-12">
								<label class="col-xs-4" for="edit-selectPlant" >반려식물 선택</label>
									<select class="form-control form-control-sm" name="companionNick">
										<option>산세베리아</option>
										<option>로즈마리</option>
										<option>부레옥잠</option>
									</select>
							</div>
                    	</div>
						<div class="form-group">
							<div class="col-xs-12">
								<label class="col-xs-4" for="edit-title">제목</label>
									<input class="form-control form-control-sm" type="text" name="diaryTitle" id="edit-title"
												required="required" />
							</div>
                    	</div>
						<div class="form-group">
							<label class="col-xs-4" for="edit-start">날짜선택</label>
							<div class="col-xs-12 input-group date" id="datapicker2">
								<input class="form-control datetimepicker-input" type="text" name="diaryDate" id="edit-date" value="2021-05-18"/>
								<div class="input-group-append" data-toggle="datetimepicker">
									<div class="input-group-text"><i class="fa fa-calendar"></i></div> 
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<label class="col-xs-4" for="edit-color">색상</label>
									<select class="form-control form-control-sm" name="diaryColor" id="edit-color">
										<option value="#D25565" style="color:#D25565;">빨간색</option>
										<option value="#9775fa" style="color:#9775fa;">보라색</option>
										<option value="#ffa94d" style="color:#ffa94d;">주황색</option>
										<option value="#74c0fc" style="color:#74c0fc;">파란색</option>
										<option value="#f06595" style="color:#f06595;">핑크색</option>
										<option value="#63e6be" style="color:#63e6be;">연두색</option>
										<option value="#a9e34b" style="color:#a9e34b;">초록색</option>
										<option value="#4d638c" style="color:#4d638c;">남색</option>
									</select>
							</div>
                    	</div>
						<label class="col-xs-4" for="edit-picture">사진</label>
						<div class="custom-file">
							<div class="col-xs-12">
								<input type="file" class="custom-file-input" name="diaryPicname" id="customFile">
								<label class="custom-file-label" for="customFile"></label>
							</div>
						</div>

						<div class="form-group">
							<div class="col-xs-12">
								<label class="col-xs-4" for="edit-desc">내용</label>
									<textarea rows="4" cols="50" class="form-control form-control-sm" name="diaryContent"
												id="edit-desc">
									</textarea>
									<p>최대200자까지작성가능(0자/200자)<p>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label class="col-xs-4" for="edit-lastWater">마지막 물 준 날</label>
							<div class="col-xs-12 input-group date" id="datapicker2">
								<input class="form-control datetimepicker-input" type="text" name="diaryLastWater" id="edit-lastWater" value="2021-05-18"/>
								<div class="input-group-append" data-toggle="datetimepicker">
									<div class="input-group-text"><i class="fa fa-calendar"></i></div> 
								</div>
							</div>
                    	</div>
            		</div>
            		<div class="modal-footer modalBtnContainer-addEvent">
                        <button type="button" class="btn btn-light" data-dismiss="modal">취소</button>
                        <button type="button" class="btn btn-primary" id="save-event">등록</button>
                    </div>
                    <div class="modal-footer modalBtnContainer-modifyEvent">
                        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
                        <button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
                        <button type="button" class="btn btn-primary" id="updateEvent">수정</button>
                	</div><!-- /.modal-body -->
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </form>
    <!-- 모달창 끝 -->

    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include> 
        
    <script>
        //input을 datepicker로 선언
    	$("#edit-date,#edit-lastWater").datepicker({
        	format: "yyyy-mm-dd",
            language : "kr"
        });                    
    </script>
</body>
</html>
