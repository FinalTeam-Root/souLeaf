<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 비밀번호 변경</title>
<jsp:include page="../common/header.jsp"></jsp:include>
</head>
<style>
.top_line {
	position: relative;
	top: -18px;
	background-color: #00bd56;
	width: 21%;
	height: 3px;
}

.wrapper {
	margin-top : 150px;
	margin-bottom : 150px;
}
.btnarea {
	width : inherit;
	height : inherit;
	margin : 40px auto;
}
.btn {
	width : 150px;
}

#changePwbtn {
	margin-right : 15px;
}

 .captcha{
   overflow: hidden;
 }
 .captcha_child{
   float: left;
 }
 .captcha_child_two{
    float: right;
 }
 .refreshBtn:hover{
    background-color: #a8a8a8;
    color: white;
    border : 1px solid #a6a6a6;
 }
 .refreshBtn{
    color: black;
    border : 1px solid #888;
    width: 110px;
    border-radius: 5px;
    height: 25px;
    display: block;
    padding : 2px 10px;
    margin: 5px 0px;
 }
</style>
<body>
<div class="container bootstrap snippet wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h4>
				비밀번호 변경<span class="badge badge-secondary"
					style="background-color: #00bd56;"></span>
			</h4>
			<hr>
			<div class="top_line"></div>
			<br> <br>
			<br> <br>
			<div class="container">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<div class="form-floating">
							<div class="form-group pb-3">
								<input type="text" placeholder="기존 비밀번호" name="memberPw"
									class="form-control " id="originalPw">
							</div>
							<div class="form-group pb-3">
								<input type="text" placeholder="새 비밀번호" name="newMemberPw"
									class="form-control" id="newPw">
								<div class="container"></div>
							</div>
								<div class="form-group pb-3">
									<input type="text" placeholder="비밀번호 확인" name="newMemberPwChk"
										class="form-control " id="newPwChk">
								</div>
								<div class="form-group">
									<div class="captcha">
										<div class="captcha_child">
											<img id="captchaImg" title="캡차 이미지" src="captchaImg.kh"
												alt="캡차 이미지" />
											<div id="captchaAudio" style="display: none"></div>
										</div>
										<div class="captcha_child_two">
											<a href="#" onclick="refreshBtn();" class="refreshBtn">
												<i class="fa fa-refresh" aria-hidden="true"></i> 새로고침
											</a> <a href="#" onclick="audio();" class="refreshBtn"> <i
												class="fa fa-volum-up" aria-hidden="true"></i> 음성듣기
											</a>
										</div>
									<input type="text" name="checkNum" class="form-control " id="checkNum">
									</div>
								</div>
								<div class="btnarea">
								<button type="submit" id="changePwbtn" class="btn btn-success">변경</button>
								<button type="submit" id="cancelbtn" class="btn btn-secondary">취소</button>
							</div>
						</div>

					</div>
				</div>
				</div>
			</div>
			<br> <br> <br>
			<hr>
		</div>
	</div>
	<script type="text/javascript">
	function audio(){
	      var rand = Math.random();

	      var url = 'captchaAudio.kh';
	      $.ajax({
	         url : url,
	         type : 'POST',
	         dataType : 'text',
	         data : 'rand='+rand,
	         async : false,
	         success : function(resp){
	           var uAgent = navigator.userAgent;
	           var soundUrl = 'captchaAudio.kh?rand='+rand;
	           // 브라우저별 오디오 처리
	           if (uAgent.indexOf('Trident') > -1 || uAgent.indexOf('MSIE') > -1) {    //IE인 경우
	             winPlayer(soundUrl);
	           } else if (!!document.createElement('audio').canPlayType){
	             try {
	               new Audio(soundUrl).play();
	             } catch (e) {
	               winPlayer(soundUrl);
	             }
	           } else {
	               window.open(soundUrl, '', 'width=1,height=1');
	           }
	        }
	      });
	    }
	    function refreshBtn(type){
	      var rand = Math.random();
	      var url = 'captchaImg.kh?rand='+rand;

	      $("#captchaImg").attr("src", url);
	    }
	    function winPlayer(objUrl){
	      $("#captchaAudio").html('<bgsoun src="'+objUrl +'">');       //bgsound 배경음악 제어
	    }

	</script>
	
</body>
</html>