<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="wrapper">
<head>
<meta charset="UTF-8">
<title>souLeaf - 로그인</title>
<link rel="icon" type="image/png" sizes="16x16"
	href="resources/images/favicon-16x16.png">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="theme-color" content="#ffffff">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">
<style type="text/css">
@font-face {
	font-family: 'NanumSquareRound';
	src:
		url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

.wrapper {
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
}

html {
	/* background: #c9ccd1;  Old browsers */
	/* background: #fff9e67a; */
	font-family: NanumSquareRound;
	background: linear-gradient(45deg, #20ffb752 0%, #bd83003b 100%);
	height: 100%;
}

body {
	/* background: #c9ccd1;  Old browsers */
	/* background: #fff9e67a; */
	background: #fff0;
}

.sideline {
	text-align: center;
}

.sideline:before, .sideline:after {
	content: '';
	border-top: 1px solid #ebebeb;
	margin: 0 20px 0 0;
	flex: 1 0 20px;
}

.sideline:after {
	margin: 0 0 0 20px;
}

a {
	-webkit-transition: .3s all ease;
	-o-transition: .3s all ease;
	transition: .3s all ease;
	color: #00bd56;
}

a:hover, a:focus {
	text-decoration: none;
	color: #00bd56;
	outline: none !important;
	font-weight: bold
}

.idbox {
	margin-bottom : 0;
}
.msg-contain {
	margin-bottom : 30px;
}
.msg{
	color :red;
	font-size:0.9vw;
}
</style>
</head>
<body>
	<div class="container p-5 mt-4">
		<div class="row m-5 no-gutters shadow-lg">
			<div class="col-md-6 d-none d-md-block">
				<img src="/resources/images/login_main_2.jpg" class="img-fluid"
					style="min-height: 100%;" />
			</div>
			<div class="col-md-6 bg-white p-5">
				<div align="center">
					<a class="navbar-brand" href="/home.kh"><img
						src="resources/images/logo.png"
						style="margin-bottom: 10px; width: 200px;"></a>
				</div>
				<div class="form-style">
						<div class="form-group pb-3 idbox">
							<input type="text" placeholder="아이디" class="form-control logininfo"
								name="memberId" id="exampleInputEmail1">
						</div>
						<div class="form-group pb-3 idbox">
							<input type="password" placeholder="비밀번호" name="memberPw"
								class="form-control logininfo" id="exampleInputPassword1">
						</div>
						<div class="msg-contain">
							<span class="msg"></span>
						</div>
						<div class="d-flex align-items-center justify-content-between">
							<div class="d-flex align-items-center">
								<input name="" type="checkbox" value="" /> <span
									class="pl-2 font-weight-bold">아이디 저장</span>
							</div>
							<div>
								<a href="#" style="font-size: 0.9vw">아이디 찾기</a>&nbsp;&nbsp;&nbsp;
								<a href="#" style="font-size: 0.9vw">비밀번호 찾기</a>
							</div>
						</div>
						<div class="pb-2">
							<button type="submit" id="loginBtn" class="btn btn-success w-100 font-weight-bold mt-2">로그인</button>
						</div>
					<div class="sideline">OR</div>
						<div class="kakao">
							<button type="submit" id="loginBtn" onclick="kakaoLogin();" class="btn btn-warning w-100 mt-2"><img src="https://img.icons8.com/metro/26/000000/speech-bubble.png" style="margin-right: 10px; width :15px; height :15px;"/>카카오 로그인</button>
						</div>
					<div class="pt-4 text-center">
						<a href="enrollView.kh" style="font-size: 0.9vw">아직 회원이 아니신가요? </a>
					</div>
				</div>

			</div>
		</div>
	</div>

	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script src="resources/js/kakaoLogin/kakaoLogin.js"></script>
	<script>
	
		$(".logininfo").on("keypress",function(e){
			if(e.keyCode == 13){
				var memberId = $("#exampleInputEmail1").val();
				var memberPw = $("#exampleInputPassword1").val();
				if(memberId == ""){
					alert("아이디를 입력해주세요.");
					return false;
				};
				if(memberPw == ""){
					alert("비밀번호를 입력해주세요.");
					return false;
				};
				$.ajax({
					url : "login.kh",
					type : "post",
					data : {"memberId":memberId, "memberPw":memberPw},
					success: function(data){
						console.log(data);
						if(data == "success"){
							$(".msg").text("");
							location.href="home.kh";
						}else {
							$(".msg").text("아이디와 비밀번호가 일치하지않습니다.");
						}
					},error:function() {

					}
				});	
			}
		});
		
	</script>
	<!——— Include the above in your HEAD tag —————>

</body>
</html>