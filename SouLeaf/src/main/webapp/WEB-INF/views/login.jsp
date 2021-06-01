<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 로그인</title>
<link rel="icon" type="image/png" sizes="16x16"  href="resources/images/favicon-16x16.png">
    <meta name="msapplication-TileColor" content="#ffffff">
	<meta name="theme-color" content="#ffffff">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<style type="text/css">
 @font-face {
    font-family: 'NanumSquareRound';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
body{
/* background: #c9ccd1;  Old browsers */ 
    /* background: #fff9e67a; */
    font-family:NanumSquareRound;
    background: linear-gradient(
45deg
, #20ffb752 0%, #bd83003b 100%);
}
a {
  -webkit-transition: .3s all ease;
  -o-transition: .3s all ease;
  transition: .3s all ease;
  color: #00bd56; }
  a:hover, a:focus {
    text-decoration: none;
    color: #00bd56;
    outline: none !important; }

.form-style input{
	border:0;
	height:50px;
	border-radius:0;
border-bottom:1px solid #ebebeb;	
}
.form-style input:focus{
border-bottom:1px solid #007bff;	
box-shadow:none;
outline:0;
background-color:#ebebeb;	
}
.sideline {
    display: flex;
    width: 100%;
    justify-content: center;
    align-items: center;
    text-align: center;
	color:#ccc;
}
button{
height:50px;	
}
.sideline:before,
.sideline:after {
    content: '';
    border-top: 1px solid #ebebeb;
    margin: 0 20px 0 0;
    flex: 1 0 20px;
}

.sideline:after {
    margin: 0 0 0 20px;
}
.kakao-btn{
	background: #F7E600;
	border-color: #F7E600;
	color: #3b1e1e;
}
</style>
</head>
<body>
 <div class="container p-5 mt-4" >
<div class="row m-5 no-gutters shadow-lg">
<div class="col-md-6 d-none d-md-block">
<img src="/resources/images/login_main_2.jpg" class="img-fluid" style="min-height:100%;" />
</div>
<div class="col-md-6 bg-white p-5">
<div align="center">
		<a class="navbar-brand" href="/home.kh"><img src="resources/images/logo.png"  style="margin-bottom: 10px; width:200px;"></a>
	</div>
<div class="form-style">
<form action="login.kh" method="post">
  <div class="form-group pb-3">    
    <input type="text" placeholder="아이디" class="form-control" name="memberId" id="exampleInputEmail1" >   
  </div>
  <div class="form-group pb-3">   
    <input type="password" placeholder="비밀번호" name="memberPw" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="d-flex align-items-center justify-content-between">
<div class="d-flex align-items-center"><input name="" type="checkbox" value="" /> <span class="pl-2 font-weight-bold">아이디 저장</span></div>
<div><a href="#">아이디 찾기</a>&nbsp;&nbsp;&nbsp; <a href="#">비밀번호 찾기</a></div>
</div>
   <div class="pb-2">
  <button type="submit" class="btn btn-success w-100 font-weight-bold mt-2">로그인</button>
   </div>
</form>
  <div class="sideline">OR</div>
  <div>
  <button type="submit" class="btn btn-warning w-100 font-weight-bold mt-2 kakao-btn"><img src="https://img.icons8.com/ios-glyphs/30/000000/filled-topic.png" style="width:23px;"/> 카카오톡계정으로 로그인</button>
  </div>
  <div class="pt-4 text-center">
  <a href="enrollView.kh">아직 회원이 아니신가요? </a>
  </div>
</div>
	
</div>
</div>
</div>


 <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!——— Include the above in your HEAD tag —————>

</body>
</html>