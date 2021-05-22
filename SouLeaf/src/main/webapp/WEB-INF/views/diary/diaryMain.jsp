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
    
    
</head>
<body>  
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include> 
    <input type="hidden" name="memberDiary" id="memberDiary" value=1>
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
									<h6 class="card-category text-gray" name="memberId">${loginUser.memberId }</h6>
									<h4 class="card-title" name="memberNick">${loginUser.memberNick }</h4>
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

						</div>
					</div>
				</div>
			</div>
		</div>

    <!-- 일기 등록, 수정 모달창 -->
   <!--  enctype="multipart/form-data" -->
    <form action="#" method="post">
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
									<select class="form-control form-control-sm" name="selectCompanion" id="selectCompanion">
										<option value="산세베리아">산세베리아</option>
										<option value="로즈마리">로즈마리</option>
										<option value="부레옥잠">부레옥잠</option>
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
								<input class="form-control datetimepicker-input" type="text" name="diaryDate" id="edit-date" />
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
									    <input type="radio" id="color-1" name="color" value="#D25565" checked>
									    <label for="color-1">
									      <span>
									      </span>
									    </label>
									  </div>
									  <div>
									    <input type="radio" id="color-2" name="color" value="#9775fa">
									    <label for="color-2">
									      <span>
									      </span>
									    </label>
									  </div>	
									  <div>
									    <input type="radio" id="color-3" name="color" value="#ffa94d">
									    <label for="color-3">
									      <span>
									      </span>
									    </label>
									  </div>
									  <div>
									    <input type="radio" id="color-4" name="color" value="#74c0fc">
									    <label for="color-4">
									      <span>
									      </span>
									    </label>
									  </div>
									  <div>
									    <input type="radio" id="color-5" name="color" value="#f06595">
									    <label for="color-5">
									      <span>
									      </span>
									    </label>
									  </div>
									  <div>
									    <input type="radio" id="color-6" name="color" value="#63e6be">
									    <label for="color-6">
									      <span>
									      </span>
									    </label>
									  </div>
									  <div>
									    <input type="radio" id="color-7" name="color" value="#4d638c">
									    <label for="color-7">
									      <span>
									      </span>
									    </label>
									  </div>
									</div>
								</div>
							</div>
                    	</div>
						<label class="col-xs-4" for="edit-picture">사진</label>
						<div class="col-xs-12">
							<div class="form-group files fileSection">
							    <input type="file" class="custom-file-input" id="customFile">
							    <label class="custom-file-label" for="customFile">Choose file</label>
						  	</div>
						</div>

						<div class="form-group">
							<div class="col-xs-12">
								<label class="col-xs-4" for="edit-desc">내용</label>
									<textarea rows="4" cols="50" class="form-control form-control-sm" name="diaryContent" id="edit-desc"></textarea>
									<p id="wordCount3">(0/최대 200자 작성가능)<p>
							</div>
						</div>
						<br>
						<div class="form-group">
							<label class="col-xs-4" for="edit-lastWater">마지막 물 준 날</label>
							<div class="col-xs-12 input-group date" id="datapicker2">
								<input class="form-control datetimepicker-input" type="text" name="diaryStartWater" id="edit-startWater"/>
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
    <script src="resources/js/diary/diaryMain.js"></script>   
    <script src='resources/js/diary/calendar.js'></script>
    <script src='resources/js/diary/ko.js'></script>
    
</body>
</html>
