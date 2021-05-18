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
	  	<div id='calendar'></div>
	  	<!-- 일기 등록, 수정 모달창 -->
	  	<form action="">
		 <div class="modal fade" tabindex="-1" role="dialog" id="eventModal">
	           <div class="modal-dialog" role="document">
	               <div class="modal-content">
	                   <div class="modal-header">
	                   		<h5>일기 등록</h5>
	                       <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
	                               aria-hidden="true">&times;</span></button>
	                       <h4 class="modal-title"></h4>
	                   </div>
	                   <div class="modal-body">
	                        <div class="form-group">
	                            <div class="col-xs-12">
	                                <label class="col-xs-4" for="edit-selectPlant">반려식물 선택</label>
	                               	<select class="form-control form-control-sm">
									  <option>산세베리아</option>
									  <option>로즈마리</option>
									  <option>부레옥잠</option>
									</select>
	                            </div>
	                        </div>
	
	                        <div class="form-group">
	                            <div class="col-xs-12">
	                                <label class="col-xs-4" for="edit-title">제목</label>
	                                <input class="form-control form-control-sm" type="text" name="edit-title" id="edit-title"
	                                    required="required" />
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="col-xs-4" for="edit-start">날짜선택</label>
	                                <input class="form-control datetimepicker-input" type="text" data-target="" name="edit-date" id="edit-date" value="2021-05-18"/>
	                            	<!-- <div class="input-group-append" data-target="" data-toggle="datetimepicker">
		                            	 <div class="input-group-text"><i class="fa fa-calendar"></i>
		                            	 </div> 
	                            	</div> -->
	                        </div>
	                        <div class="form-group">
	                            <div class="col-xs-12">
	                                <label class="col-xs-4" for="edit-color">색상</label>
	                                <select class="form-control form-control-sm" name="color" id="edit-color">
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
	                        <br>
	                        <div class="custom-file">
	                            <div class="col-xs-12">
	                                <input type="file" class="custom-file-input" id="customFile">
 									<label class="custom-file-label" for="customFile">사진 선택</label>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <div class="col-xs-12">
	                                <label class="col-xs-4" for="edit-desc">내용</label>
	                                <textarea rows="4" cols="50" class="form-control form-control-sm" name="edit-desc"
	                                    id="edit-desc"></textarea>
	                                <p>최대200자까지작성가능(0자/200자)<p>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label class="col-xs-4" for="edit-lastWater">마지막 물 준 날</label>
	                           	<div class="col-xs-12 input-group date" id="datapicker2">
	                                <input class="form-control datetimepicker-input" type="text" data-target="#datapicker2" name="edit-lastWater" id="edit-lastWater" value="2021-05-18"/>
	                            	<div class="input-group-append" data-target="#datapicker2" data-toggle="datetimepicker">
		                            	 <div class="input-group-text"><i class="fa fa-calendar"></i>
		                            	 </div> 
	                            	</div>
	                            </div>
	                        </div>
	                    </div>
	                    <div class="modal-footer modalBtnContainer-addEvent">
	                        <button type="button" class="btn btn-light" data-dismiss="modal">취소</button>
	                        <button type="button" class="btn btn-primary" id="save-event">저장</button>
	                    </div>
	                    <div class="modal-footer modalBtnContainer-modifyEvent">
	                        <button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
	                        <button type="button" class="btn btn-danger" id="deleteEvent">삭제</button>
	                        <button type="button" class="btn btn-primary" id="updateEvent">수정</button>
	                    </div>
	                </div><!-- /.modal-content -->
	            </div><!-- /.modal-dialog -->
	        </div><!-- /.modal -->
	       </form>
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
